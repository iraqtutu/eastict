package com.eastict.guoli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ControllerGenerator {
	static String[] matchMethodNames = new String[] { "insert","selectByPrimaryKey"};

	// 扫描指定命名空间下以Mapper结尾的接口
	public void genControllers(String pojoPackage,String mapperPackage,String servicePackage,String targetNameSpace,String savePath) {
		List<Class<?>> classes = ClassUtil.getClasses(mapperPackage);
		for (Class<?> cls : classes) {
			String name = cls.getSimpleName();
			if (name.endsWith("Mapper") && cls.isInterface()) {
				// 生成该接口对应的Controller
				genController(pojoPackage,targetNameSpace,servicePackage, cls,savePath);
			}
		}
	}

	// packageName:生成Controller到该命名空间下面
	// clsInterf提供参照的Mapper类
	void genController(String pojoPackage,String targetPackageName,String servicePackage, Class<?> clsInterf,String savePath) {
		String mapperType = clsInterf.getSimpleName();
		String serviceType = clsInterf.getSimpleName().replaceAll("Mapper", "Service");
		String pojoType = clsInterf.getSimpleName().replaceAll("Mapper", "");
		String serviceVarname = "_" + serviceType;
		StringBuilder sb = new StringBuilder();
		Method[] mthds = clsInterf.getDeclaredMethods();
		// TODO:插入package信息
		// 插入引用信息
		List<String> imports = new ArrayList<String>();
		imports.add(servicePackage + "." +serviceType);
		imports.add(pojoPackage + "." +pojoType);
		imports.add("java.util.List");
		imports.add("org.springframework.beans.factory.annotation.Autowired");
		imports.add("org.springframework.stereotype.Controller");
		imports.add("org.springframework.web.bind.annotation.PathVariable");
		imports.add("org.springframework.web.bind.annotation.RequestMapping");
		imports.add("org.springframework.web.bind.annotation.RequestMethod");
		imports.add("org.springframework.web.bind.annotation.ResponseBody");
		imports.add("com.eastict.pojo.CusResult");
		imports.add("com.eastict.pojo.EUDataGridResult");
		List<String> methods = new ArrayList<String>();
		
		// imports.contains(o)
		for (Method mtd : mthds) {
			String tmp = getControlMethod(serviceVarname,serviceType,mtd, pojoType, imports);
			methods.add(tmp);
		}


		// -----定义Controller
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
		sb.append("@Controller\n");
		sb.append("public class " + pojoType + "Controller {\n");
		sb.append("	@Autowired\n");
		sb.append("	private " + serviceType + " " + serviceVarname + ";\n");
		for (String str : methods) {
			sb.append(str);
			//sb.append("\n");
		}
		//写入批量访问代码
		/*@RequestMapping("/item/list")
		//@ResponseBody
		//public EUDataGridResult getItemList(Integer page, Integer rows) {
		//	EUDataGridResult result = itemService.getItemList(page, rows);
		//	return result;
		}*/
		sb.append("	@RequestMapping(\"/" + pojoType + "/list\")\n");
		sb.append("	@ResponseBody\n");
		sb.append("	public EUDataGridResult get");
		sb.append(pojoType + "List(Integer page, Integer rows) {\n");
		
		sb.append("		EUDataGridResult result = ");
		sb.append(serviceVarname);
		sb.append(".get");
		sb.append(pojoType);
		sb.append("List(page, rows);\n");
		sb.append("		return result;\n");
		sb.append("	}\n");
		sb.append("}");
		// sb为接口内容，sbImpl为实现内容，写出到文件即可
		WriteStringToFile(savePath,targetPackageName,pojoType + "Controller.java",sb.toString());
	}

	// 从Mapper某个方法反射出Controller的接口方法
	private String getControlMethod(String serviceVarname,String serviceType,Method mtd, String baseType, List<String> imports) {
		StringBuilder sb = new StringBuilder();
		String parType;
		String simpleParType;
		String parName;
		if(mtd.getName().equals("selectByPrimaryKey")){
			parType = mtd.getParameterTypes()[0].getName();
			if(!imports.contains(parType)){
				imports.add(parType);
			}
			simpleParType = mtd.getParameterTypes()[0].getSimpleName();
			parName = "keyVal";
			sb.append("	@RequestMapping(\"/");
			sb.append(baseType);
			sb.append("/{");
			//此处写入变量名
			sb.append(parName);
			sb.append("}\")\n");
			sb.append("	@ResponseBody\n");
			//写函数声明部分
			sb.append("	public " + baseType + " " + mtd.getName() + "(");
			sb.append("@PathVariable ");
			sb.append(simpleParType);
			sb.append(" ");
			sb.append(parName);
			sb.append("){\n");
			//写函数体部分
			sb.append("		");
			sb.append(baseType);
			sb.append(" _" + baseType + " = ");
			sb.append(serviceVarname);
			sb.append("." + mtd.getName() + "(" );
			sb.append(parName);
			sb.append(");\n");
			sb.append("		return " + " _" + baseType);
			sb.append(";\n");
			sb.append("	}\n");
			sb.append("");
		}else if(mtd.getName().equals("insert")){
			parType = mtd.getParameterTypes()[0].getName();
			if(!imports.contains(parType)){
				imports.add(parType);
			}
			simpleParType = mtd.getParameterTypes()[0].getSimpleName();
			parName = "_val";
			sb.append("	@RequestMapping(value=\"/");
			sb.append(baseType);
			sb.append("/save\", method=RequestMethod.POST)\n");
			sb.append("	@ResponseBody\n");
			//写函数声明部分
			sb.append("	public CusResult " + mtd.getName() + "(");
			sb.append(simpleParType);
			sb.append(" ");
			sb.append(parName);
			sb.append("){\n");
			//写函数体部分
			sb.append("		");
			sb.append("CusResult ");
			sb.append(" _rlt" + " = ");
			sb.append(serviceVarname);
			sb.append("." + mtd.getName() + "(" );
			sb.append(parName);
			sb.append(");\n");
			sb.append("		return " + " _rlt");
			sb.append(";\n");
			sb.append("	}\n");
			sb.append("");
		}
		return sb.toString();
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
