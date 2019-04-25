import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import br.gov.cultura.sistema.util.ReflectionUtils;



public class GeraScriptServicos {
	
	private static String applicationPath;
	
	public static void main(String[] args) throws Exception {
		printScript();
	}
	
	private static void printScript() throws Exception {
		System.out.println("USE [DBMINC]");
		System.out.println("GO");
		System.out.println("DECLARE @IdServico bigint;\n");
		
		String packageName = "br.gov.cultura.sistema.pessoa.rest";
		Iterable<Class<?>> classes = ReflectionUtils.getClasses(packageName);
		
		for (Class<?> clazz : classes) {
			if(clazz.getAnnotation(ApplicationPath.class) != null) {
				applicationPath = clazz.getAnnotation(ApplicationPath.class).value();
				break;
			}
		}
		
		for (Class<?> clazz : classes) {
			if(clazz.getAnnotation(Path.class) != null) {
				String classPath = clazz.getAnnotation(Path.class).value();
				List<String> webResourceNames = new ArrayList<String>();
				String classServiceName = getClassServiceName(clazz.getSimpleName());
				System.out.printf ("----- %s -----------------------------------------------------------------------------\n", classServiceName);
				for (Method method : clazz.getMethods()) {
					if(method.getAnnotation(Path.class) != null) {
						String methodPath = method.getAnnotation(Path.class).value();
						String webResourceName = getWebResourceName(classPath, methodPath);
						
						// Se já existir um 'webResourceName' igual ele passa para a próxima iteração
						if(webResourceNames.contains(webResourceName))
							continue;
						
						String type = getOperationType(method);
						System.out.printf ("--> %s\n",type);
						System.out.println("set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;\n");
						System.out.println("INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])");
						System.out.println("\tVALUES (@IdServico,4,2,'A',NULL,0");
						System.out.printf ("\t\t,'%s'\n", getRoleName(classPath, methodPath));
						System.out.println("\t\t,'WebService do Corporativo'");
						System.out.printf ("\t\t,'%s'\n", printFirstLetters(String.format("CORP%s%s", classServiceName.toUpperCase(), type), 30));
						System.out.printf ("\t\t,'/pessoa-ws%s'\n", getUrlPattern(classPath, methodPath));
						System.out.printf ("\t\t,'/pessoa-ws%s'\n", getUrlPattern(classPath, methodPath));
						System.out.println("\t\t,'/opt/jboss-as-7.1.1-minc/standalone/data/content')");
						webResourceNames.add(webResourceName);
					}
				}
			}
		}
	}
	
	private static String getOperationType(Method method) {
		String type = "";
		if(method.getAnnotation(GET.class) != null) type = type.concat("CONSULTAR"); 
		if(method.getAnnotation(POST.class) != null) type = type.concat("CADASTRAR"); 
		if(method.getAnnotation(PUT.class) != null) type = type.concat("ATUALIZAR"); 
		if(method.getAnnotation(DELETE.class) != null) type = type.concat("DELETAR");
		return type;
	}
	
	private static String getClassServiceName(String className) {
		int index = className.indexOf("RESTService");
		return className.substring(0, index);
	}
	
	private static String getUrlPattern(String classPath, String methodPath) {
		return applicationPath.concat(classPath).concat("/").concat(formatMethodPath(methodPath));
	}
	
	private static String getRoleName(String classPath, String methodPath) {
		return new StringBuilder()
		.append("corporativo_")
		.append(classPath.replaceAll("/", ""))
		.append("_")
		.append(formatMethodPath(methodPath))
		.toString();
	}
	
	private static String getWebResourceName(String classPath, String methodPath) {
		classPath = classPath.replaceAll("/", "");
		methodPath = formatMethodPath(methodPath);
		
		return classPath + "_" + methodPath;
	}
	
	private static String formatMethodPath(String methodPath) {
		if(methodPath.lastIndexOf("/") > 0) {
			int index = methodPath.substring(1).indexOf("/");
			methodPath = methodPath.substring(0, ++index);
		}
		
		methodPath = methodPath.replaceAll("/", "");
		if(methodPath.indexOf('{') > 0) {
			int index = methodPath.indexOf('{');
			methodPath = methodPath.substring(0, index);
		}
		
		return methodPath;
	}
	
	private static String printFirstLetters(String str, int qntd) {
		if(str.length() > 30)
			str = str.substring(0, 30);
		
		return str;
	}

}