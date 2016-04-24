package com.eastict.guoli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class JspGenerator {
	// 应该被忽略的POJO文件(文件名匹配正则表达式，逗号分隔)
	String[] ignorPojoExp = new String[] { "\\$", "Example","Key" };
	List<Pattern> ignorPatternLst = new ArrayList<Pattern>();
	HashMap<String, String> mapPattern = new HashMap<String, String>();
	String jspTemplate = "";

	// 从pojo生成jspform
	// 1,ClassUtil.getClasses("com.eastict.guoli");扫描指定包下面的所有POJO
	// 2,遍历POJO,Example不管
	// 反射获得POJO所有字段
	// 遍历POJO字段，逐个输出<>
	// 3,
	// 4,
/*	public static void main(String[] args) throws Exception {
		JspGenerator gen = new JspGenerator();
		gen.genJsps("stylebase", "eastict.pojo.pam");
	}
*/
	public void genJsps(String styleName, String nameSpace,String savePath) {
		initAll(styleName);
		List<Class<?>> classes = ClassUtil.getClasses(nameSpace);
		for (Class<?> cls : classes) {
			String name = cls.getSimpleName();
			boolean ignor = false;
			for (String str : ignorPojoExp) {
				if (name.endsWith(str)) {
					ignor = true;
				}
			}
			if (!ignor) {
				//生成JSP
				WriteStringToFile(savePath,"jsp",cls.getSimpleName() + "add.jsp",getPojoJsp(cls));
			}
		}
	}

	String getPojoJsp(Class<?> clz) {
		StringBuilder sb = new StringBuilder();
		Field[] flds = clz.getDeclaredFields();
		for (Field fld : flds) {
			String fldName = fld.getName();
			Class<?> clsFld = fld.getType();
			String clsName = clsFld.getName();
			String pattern = "<div>未找到$field对应类型的控件模板</div>\n";
			//System.out.println(clsName);
			switch (clsName) {
			case "java.lang.String":
				pattern = mapPattern.get("string");
				break;
			case "java.lang.Boolean":
			case "boolean":
				pattern = mapPattern.get("boolean");
				break;
			case "java.lang.Integer":
			case "java.lang.Long":
			case "long":
			case "integer":
			case "int":
				pattern = mapPattern.get("number");
				break;
			case "java.util.Date":
				pattern = mapPattern.get("date");
				break;
			default:
				System.out.println(clsName);
			}
			// 字符串替换
			String tmp = pattern.replaceAll("\\$field", fldName);
			sb.append(tmp);
		}
		return sb.toString();
	}

	// 加载指定样式的模板！
	void initAll(String styleName) {
		// 初始化模板
		mapPattern.clear();
		String path = "tmplates/" + styleName + "/";
		jspTemplate = path + "jsp.gl";
		String[] types = new String[] { "string", "number", "boolean", "date", "time", "file" };
		String fileName = "";
		String exp = "";
		for (String typ : types) {
			fileName = path + typ + ".gl";
			exp = file2String(fileName);
			mapPattern.put(typ, exp);
		}
	}

	String file2String(String file) {
		// ClassLoader loader = this.getClass().getClassLoader();
		InputStream stream = this.getClass().getResourceAsStream(file);
		InputStreamReader sreader = new InputStreamReader(stream, Charset.defaultCharset());
		BufferedReader reader = new BufferedReader(sreader);
		String tmpStr = null;
		StringBuilder sb = new StringBuilder();
		try {
			while ((tmpStr = reader.readLine()) != null) {
				sb.append(tmpStr);
				sb.append("\n");
			}
		} catch (IOException ex) {

		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
