package com.eastict.guoli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ServiceGenerator {
	static String[] matchMethodNames = new String[] { "insert", "insertSelective", "selectByPrimaryKey",
			"updateByPrimaryKey", "updateByPrimaryKeySelective", "deleteByPrimaryKey" };

	public static void main(String[] args) throws Exception {
		//jsp模板样式(模板组)
		String jspStyle = "stylebase";
		String savePath = "./genSource";
		//被扫描的命名空间
		String pojoPackage = "eastict.pojo.pam";
		String mapperPackage = "eastict.mapper.pam";
		//生成文件的命名空间
		String targetServicePackage =  "eastict.service.pam";
		String targetControllerPackage =  "eastict.controller.pam";
		ServiceGenerator gen = new ServiceGenerator();
		System.out.println("使用方法：");
		System.out.println("1,把POJO和Mapper的包复制到guoli的源码目录下");
		System.out.println("2,修改guli的main函数，指定扫描的命名空间和输出的目录");
		//扫描eastict.mapper.pam包下的所有Mapper,生成Service到./genSource目录下面，包名为eastict.service
		gen.genServices(mapperPackage,targetServicePackage,savePath);
		//扫描eastict.pojo.pam包下的所有pojo,生成jsp到./genSource目录下面，目录名为:jsp
		JspGenerator jspgen = new JspGenerator();
		jspgen.genJsps(jspStyle, pojoPackage,"./genSource");
		//生成Controller
		ControllerGenerator conGen = new ControllerGenerator();
		conGen.genControllers(pojoPackage, mapperPackage, targetServicePackage, targetControllerPackage, savePath);
	}

	// 扫描指定命名空间下以Mapper结尾的接口
	public void genServices(String nameSpace, String targetNameSpace,String savePath) {
		List<Class<?>> classes = ClassUtil.getClasses(nameSpace);
		for (Class<?> cls : classes) {
			String name = cls.getSimpleName();
			if (name.endsWith("Mapper") && cls.isInterface()) {
				// 生成该接口对应的Service
				genService(targetNameSpace, cls,savePath);
			}
		}
	}

	// packageName:生成接口到该命名空间下面,Service实现则生成到子命名空间impl中
	// clsInterf提供参照的Mapper类
	void genService(String targetPackageName, Class<?> clsInterf,String savePath) {
		String impPackageName = targetPackageName + ".impl";
		String mapperType = clsInterf.getSimpleName();
		String mapperVarName = "_" + mapperType;
		StringBuilder sb = new StringBuilder();
		Method[] mthds = clsInterf.getDeclaredMethods();
		String baseType = clsInterf.getSimpleName().replaceAll("Mapper", "");
		String baseTypeFullName = clsInterf.getSimpleName().replaceAll("Mapper", "");
		// TODO:插入package信息
		// 插入引用信息
		List<String> imports = new ArrayList<String>();
		imports.add("com.eastict.pojo.CusResult");
		imports.add("com.eastict.pojo.EUDataGridResult");
		List<String> methods = new ArrayList<String>();
		// imports.contains(o)
		for (Method mtd : mthds) {
			String tmp = getInterfaceMethodDeclare(mtd, baseType, imports);
			methods.add(tmp);
		}
		// 强制实现批量分页查询接口
		methods.add("EUDataGridResult get" + baseType + "List(int page, int rows);");
		// 开始组合文本内容
		sb.append("package ");
		sb.append(targetPackageName);
		sb.append(";\n");
		for (String imp : imports) {
			if (!imp.equals("int")) {
				sb.append("import ");
				sb.append(imp);
				sb.append(";\n");
			}
		}
		// -----定义接口
		sb.append("public interface " + baseType + "Service {\n");
		for (String str : methods) {
			sb.append("	");
			sb.append(str);
			sb.append("\n");
		}
		sb.append("}");

		//System.out.println("生成服务接口为：" + sb.toString());

		// 开始组合服务实现内容
		// 导入服务接口依赖
		StringBuilder sbImpl = new StringBuilder();
		sbImpl.append("package ");
		sbImpl.append(impPackageName);
		sbImpl.append(";\n");
		sbImpl.append("import ");
		sbImpl.append(clsInterf.getName());
		sbImpl.append(";\n");
		imports.add(targetPackageName + "." + baseType + "Service");
		for (String imp : imports) {
			if (!imp.equals("int")) {
				sbImpl.append("import ");
				sbImpl.append(imp);
				sbImpl.append(";\n");
			}
		}
		//服务实现多几个import
		sbImpl.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sbImpl.append("import org.springframework.stereotype.Service;\n");
		sbImpl.append("import com.alibaba.druid.sql.visitor.functions.Insert;\n");
		sbImpl.append("import com.github.pagehelper.PageHelper;\n");
		sbImpl.append("import com.github.pagehelper.PageInfo;\n");
		sbImpl.append("import com.eastict.common.utils.IDUtils;\n");
		// 加入对Mapper的依赖@Service
		sbImpl.append("@Service\n");
		sbImpl.append("public class ");
		sbImpl.append(baseType + "Service");
		sbImpl.append("Impl  implements ");
		sbImpl.append(baseType + "Service{\n");
		sbImpl.append("	@Autowired\n");
		sbImpl.append("	private " + mapperType + " ");
		sbImpl.append(mapperVarName);
		sbImpl.append(";\n");
		// -------------写入方法体
		for (Method mtd1 : mthds) {
			sbImpl.append("	@Override\n");
			String tmp = getInterfaceMethodImpl(mtd1, baseType, imports, mapperVarName);
			sbImpl.append(tmp);
		}
		// -------------强制实现方法
		sbImpl.append("	@Override\n");
		sbImpl.append("	public EUDataGridResult get" + baseType + "List(int page, int rows){\n");
		sbImpl.append("		//请根据需要实现分页查询，通过Example查询实现\n");
		sbImpl.append("		return null;\n");
		sbImpl.append("	}\n");
		// -------------
		sbImpl.append("}\n");
		// sb为接口内容，sbImpl为实现内容，写出到文件即可
		WriteStringToFile(savePath,targetPackageName,baseType + "Service.java",sb.toString());
		WriteStringToFile(savePath,impPackageName,baseType + "ServiceImpl.java",sbImpl.toString());
	}

	// 从Mapper某个方法反射出Service的接口方法
	private String getInterfaceMethodDeclare(Method mtd, String baseType, List<String> imports) {
		String rtType = "CusResult";
		StringBuilder sbMethdNew = new StringBuilder();
		String rtTypFull = mtd.getReturnType().getName();
		if (!imports.contains(rtTypFull)) {
			imports.add(rtTypFull);
		}
		if (mtd.getName().startsWith("select")) {
			// 判断返回值类型
			if (mtd.getReturnType().getName().equals("java.util.List")) {
				rtType = "List<" + baseType + "> ";
			} else {
				rtType = baseType + " ";
			}
		} else {
			rtType = "CusResult ";
		}
		sbMethdNew.append(rtType);
		sbMethdNew.append(mtd.getName());
		sbMethdNew.append("(");
		Class<?>[] parTypes = mtd.getParameterTypes();
		if (parTypes != null) {
			int index = 0;
			for (Class<?> cls : parTypes) {
				String parTypeFull = cls.getName();
				if (!imports.contains(parTypeFull)) {
					imports.add(parTypeFull);
				}
				String parType = cls.getSimpleName();
				String parVar = "_" + parType;
				if (index > 0) {
					sbMethdNew.append(",");
				}
				sbMethdNew.append(parType);
				sbMethdNew.append(" ");
				sbMethdNew.append(parVar);
				index++;
			}
		}
		sbMethdNew.append(");");
		return sbMethdNew.toString();
	}

	// 从Mapper某个方法反射出Service的实现方法
	private String getInterfaceMethodImpl(Method mtd, String baseType, List<String> imports, String mapperName) {
		String rtType = "CusResult";
		StringBuilder sbMethdNew = new StringBuilder();
		String rtTypFull = mtd.getReturnType().getName();
		if (!imports.contains(rtTypFull)) {
			imports.add(rtTypFull);
		}
		if (mtd.getName().startsWith("select")) {
			// 判断返回值类型
			if (mtd.getReturnType().getName().equals("java.util.List")) {
				rtType = "List<" + baseType + "> ";
			} else {
				rtType = baseType + " ";
			}
		} else {
			rtType = "CusResult ";
		}
		sbMethdNew.append("	public ");
		sbMethdNew.append(rtType);
		sbMethdNew.append(mtd.getName());
		sbMethdNew.append("(");
		Class<?>[] parTypes = mtd.getParameterTypes();
		StringBuilder sbArgs = new StringBuilder();
		if (parTypes != null) {
			int index = 0;
			for (Class<?> cls : parTypes) {
				String parTypeFull = cls.getName();
				if (!imports.contains(parTypeFull)) {
					imports.add(parTypeFull);
				}
				String parType = cls.getSimpleName();
				String parVar = "_" + parType;
				if (index > 0) {
					sbMethdNew.append(",");
					sbArgs.append(",");
				}
				sbMethdNew.append(parType);
				sbMethdNew.append(" ");
				sbMethdNew.append(parVar);
				sbArgs.append(parVar);
				index++;
			}
		}
		sbMethdNew.append("){\n");
		// 具体实现代码
		if (rtType.startsWith("CusResult")) {
			sbMethdNew.append("		Object rlt = ");
		} else {
			sbMethdNew.append("		return ");
		}
		sbMethdNew.append(mapperName);
		sbMethdNew.append(".");
		sbMethdNew.append(mtd.getName());
		sbMethdNew.append("(");
		sbMethdNew.append(sbArgs.toString());
		sbMethdNew.append(");\n");
		if (rtType.startsWith("CusResult")) {
			sbMethdNew.append("		return CusResult.ok(rlt);\n");
		}
		sbMethdNew.append("	}\n");
		return sbMethdNew.toString();
	}

	private void WriteStringToFile(String basePath, String nameSpace, String fileName, String content) {
		String tmp = nameSpace.replace(".", "/");
		String fullPath = basePath + "/" + tmp;
		fullPath = fullPath.replace("//", "/");
		ensurePath(fullPath);
		String newFile = fullPath + "/" + fileName;
		File txt = new File(newFile);
		try {
			if (!txt.exists()) {
				txt.createNewFile();
			}
			FileWriter writer = new FileWriter(txt);
			BufferedWriter bwriter = new BufferedWriter(writer);
			bwriter.write(content);
			//writer.close();
			bwriter.flush();
			bwriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void ensurePath(String fullPath) {
		String paths[] = fullPath.split("/");
		String dir = paths[0];
		File dirFile = new File(dir);
		if (!dirFile.exists()) {
			dirFile.mkdir();
			System.out.println("创建目录为：" + dir);
		}
		for (int i = 1; i < paths.length; i++) {
			try {
				dir = dir + "/" + paths[i];
				dirFile = new File(dir);
				if (!dirFile.exists()) {
					dirFile.mkdir();
					System.out.println("创建目录为：" + dir);
				}
			} catch (Exception err) {
				System.err.println("文件夹创建发生异常");
			}
		}
	}

}
