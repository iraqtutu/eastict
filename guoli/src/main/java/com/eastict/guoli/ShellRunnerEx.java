package com.eastict.guoli;

//支持从classpath获取MyBatis-Generator配置文件
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.logging.LogFactory;

/**
 * This class allows the code generator to be run from the command line.
 * 
 * @author Jeff Butler
 */
public class ShellRunnerEx {
	private static final String CONFIG_FILE = "-configfile"; //$NON-NLS-1$
	private static final String OVERWRITE = "-overwrite"; //$NON-NLS-1$
	private static final String CONTEXT_IDS = "-contextids"; //$NON-NLS-1$
	private static final String TABLES = "-tables"; //$NON-NLS-1$
	private static final String VERBOSE = "-verbose"; //$NON-NLS-1$
	private static final String FORCE_JAVA_LOGGING = "-forceJavaLogging"; //$NON-NLS-1$
	private static final String HELP_1 = "-?"; //$NON-NLS-1$
	private static final String HELP_2 = "-h"; //$NON-NLS-1$
	private static boolean isClassPathConfig = false;

	public static void main(String[] args) {
		ArrayList<String> lstPojoNamespace = new ArrayList<String>();
		ArrayList<String> lstMapperNamespace = new ArrayList<String>();
/*		if (args.length == 0) {
			usage();
			// System.exit(0);//别退出去啊！
			return; // only to satisfy compiler, never returns
		}*/

		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put(CONFIG_FILE, "generatorConfig.xml");

		if (arguments.containsKey(HELP_1)) {
			usage();
			System.exit(0);
			return; // only to satisfy compiler, never returns
		}

		if (!arguments.containsKey(CONFIG_FILE)) {
			writeLine(getString("RuntimeError.0")); //$NON-NLS-1$
			return;
		}

		List<String> warnings = new ArrayList<String>();

		String configfile = arguments.get(CONFIG_FILE);
		File configurationFile = new File(configfile);
		if (!configurationFile.exists()) {
			// 尝试从classpath加载文件
			URL url = ShellRunnerEx.class.getClassLoader().getResource(configfile);
			if (url == null) {
				writeLine(getString("RuntimeError.1", configfile)); //$NON-NLS-1$
				return;
			} else {
				isClassPathConfig = true;
			}
		}

		Set<String> fullyqualifiedTables = new HashSet<String>();
		if (arguments.containsKey(TABLES)) {
			StringTokenizer st = new StringTokenizer(arguments.get(TABLES), ","); //$NON-NLS-1$
			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				if (s.length() > 0) {
					fullyqualifiedTables.add(s);
				}
			}
		}

		Set<String> contexts = new HashSet<String>();
		if (arguments.containsKey(CONTEXT_IDS)) {
			StringTokenizer st = new StringTokenizer(arguments.get(CONTEXT_IDS), ","); //$NON-NLS-1$
			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				if (s.length() > 0) {
					contexts.add(s);
				}
			}
		}

		try {
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config;
			if (isClassPathConfig) {
				InputStream stm = ShellRunnerEx.class.getClassLoader().getResourceAsStream(configfile);
				config = cp.parseConfiguration(stm);
			} else {
				config = cp.parseConfiguration(configurationFile);
			}
			// 填充lstPojoNamespace,lstMapperNamespace
			List<Context> ctxs = config.getContexts();
			for (Context ctx : ctxs) {
				String targetPojoPackage = ctx.getJavaModelGeneratorConfiguration().getTargetPackage();
				if (!lstPojoNamespace.contains(targetPojoPackage)) {
					lstPojoNamespace.add(targetPojoPackage);
				}
				String targetMapperPackage = ctx.getSqlMapGeneratorConfiguration().getTargetPackage();
				if (!lstMapperNamespace.contains(targetMapperPackage)) {
					lstMapperNamespace.add(targetMapperPackage);
				}
			}
			boolean mapperExist = false;
			// 检查目标命名空间，如果存在，则说明已经生成POJO和Mapper文件，则开始生成Service,Control,JSP
			for (String ns : lstMapperNamespace) {
				String tmpDir = ns.replace('.', '/');
				Enumeration<URL> dirs = ShellRunnerEx.class.getClassLoader().getResources(tmpDir);
				if (dirs.hasMoreElements()) {
					// 目标命名空间已经存在
					//URL url = dirs.nextElement();
					mapperExist = true;
					break;
				}
			}

			if (!mapperExist) {
				DefaultShellCallback shellCallback = new DefaultShellCallback(arguments.containsKey(OVERWRITE));
				MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
				ProgressCallback progressCallback = arguments.containsKey(VERBOSE) ? new VerboseProgressCallback()
						: null;
				myBatisGenerator.generate(progressCallback, contexts, fullyqualifiedTables);
				System.out.println("POJO,Mapper已经生成!请刷新项目并重新执行程序以生成Service,Controller,JSP的内容");
			} else {
				System.out.println("果粒代码生成器-----by 北京东方信通科技有限公司 陈昌建");
				System.out.println("检测到POJO,Mapper,开始成Service,Controller,JSP的内容");
				System.out.println("如要重新生成POJO,Mapper,请删除项目中的对应包后再次运行本程序");
				for (Context ctx : ctxs) {
					String targetPojoPackage = ctx.getJavaModelGeneratorConfiguration().getTargetPackage();
					String targetMapperPackage = ctx.getSqlMapGeneratorConfiguration().getTargetPackage();
					//生成Service
					//Shell.class.getClassLoader().
					//生成Controller
					
					//生成JSP
					//jsp模板样式(模板组)
					String jspStyle = "stylebase";
					String savePath = ctx.getJavaModelGeneratorConfiguration().getTargetProject();
					//被扫描的命名空间
					String pojoPackage = targetPojoPackage;
					String mapperPackage = targetMapperPackage;
					//生成文件的命名空间
					String targetServicePackage =  "eastict.service";
					String targetControllerPackage =  "eastict.controller";
					if(targetMapperPackage.indexOf(".mapper.") > 0){
						targetServicePackage = targetMapperPackage.replaceAll("mapper", "service");
						targetControllerPackage = targetMapperPackage.replaceAll("mapper", "controller");
					}
					ServiceGenerator gen = new ServiceGenerator();
					//扫描eastict.mapper.pam包下的所有Mapper,生成Service到./genSource目录下面，包名为eastict.service
					gen.genServices(mapperPackage,targetServicePackage,savePath);
					//扫描eastict.pojo.pam包下的所有pojo,生成jsp到./genSource目录下面，目录名为:jsp
					JspGenerator jspgen = new JspGenerator();
					jspgen.genJsps(jspStyle, pojoPackage,"./genJSP");
					//生成Controller
					ControllerGenerator conGen = new ControllerGenerator();
					conGen.genControllers(pojoPackage, mapperPackage, targetServicePackage, targetControllerPackage, savePath);
				}
			}

		} catch (XMLParserException e) {
			writeLine(getString("Progress.3")); //$NON-NLS-1$
			writeLine();
			for (String error : e.getErrors()) {
				writeLine(error);
			}

			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (InvalidConfigurationException e) {
			writeLine(getString("Progress.16")); //$NON-NLS-1$
			for (String error : e.getErrors()) {
				writeLine(error);
			}
			return;
		} catch (InterruptedException e) {
			// ignore (will never happen with the DefaultShellCallback)
			;
		}

		for (String warning : warnings) {
			writeLine(warning);
		}

		if (warnings.size() == 0) {
			writeLine(getString("Progress.4")); //$NON-NLS-1$
		} else {
			writeLine();
			writeLine(getString("Progress.5")); //$NON-NLS-1$
		}
	}

	private static void usage() {
		System.out.println("果粒代码生成器-----by 北京东方信通科技有限公司 陈昌建");
		String lines = getString("Usage.Lines"); //$NON-NLS-1$
		int iLines = Integer.parseInt(lines);
		for (int i = 0; i < iLines; i++) {
			String key = "Usage." + i; //$NON-NLS-1$
			writeLine(getString(key));
		}
	}

	private static void writeLine(String message) {
		System.out.println(message);
	}

	private static void writeLine() {
		System.out.println();
	}

	private static Map<String, String> parseCommandLine(String[] args) {
		List<String> errors = new ArrayList<String>();
		Map<String, String> arguments = new HashMap<String, String>();

		for (int i = 0; i < args.length; i++) {
			if (CONFIG_FILE.equalsIgnoreCase(args[i])) {
				if ((i + 1) < args.length) {
					arguments.put(CONFIG_FILE, args[i + 1]);
				} else {
					errors.add(getString("RuntimeError.19", CONFIG_FILE)); //$NON-NLS-1$
				}
				i++;
			} else if (OVERWRITE.equalsIgnoreCase(args[i])) {
				arguments.put(OVERWRITE, "Y"); //$NON-NLS-1$
			} else if (VERBOSE.equalsIgnoreCase(args[i])) {
				arguments.put(VERBOSE, "Y"); //$NON-NLS-1$
			} else if (HELP_1.equalsIgnoreCase(args[i])) {
				arguments.put(HELP_1, "Y"); //$NON-NLS-1$
			} else if (HELP_2.equalsIgnoreCase(args[i])) {
				// put HELP_1 in the map here too - so we only
				// have to check for one entry in the mainline
				arguments.put(HELP_1, "Y"); //$NON-NLS-1$
			} else if (FORCE_JAVA_LOGGING.equalsIgnoreCase(args[i])) {
				LogFactory.forceJavaLogging();
			} else if (CONTEXT_IDS.equalsIgnoreCase(args[i])) {
				if ((i + 1) < args.length) {
					arguments.put(CONTEXT_IDS, args[i + 1]);
				} else {
					errors.add(getString("RuntimeError.19", CONTEXT_IDS)); //$NON-NLS-1$
				}
				i++;
			} else if (TABLES.equalsIgnoreCase(args[i])) {
				if ((i + 1) < args.length) {
					arguments.put(TABLES, args[i + 1]);
				} else {
					errors.add(getString("RuntimeError.19", TABLES)); //$NON-NLS-1$
				}
				i++;
			} else {
				errors.add(getString("RuntimeError.20", args[i])); //$NON-NLS-1$
			}
		}

		if (!errors.isEmpty()) {
			for (String error : errors) {
				writeLine(error);
			}

			throw new RuntimeException(errors.toString());
		}

		return arguments;
	}
}
