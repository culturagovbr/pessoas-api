import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import br.gov.cultura.sistema.util.ReflectionUtils;


public class GeraRolesServicos {
	
	private static String applicationPath;
	
	public static void main(String[] args) throws Exception {
		printRoles();
	}
	
	private static void printRoles() throws Exception {
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
				for (Method method : clazz.getMethods()) {
					if(method.getAnnotation(Path.class) != null) {
						String methodPath = method.getAnnotation(Path.class).value();
						String webResourceName = getWebResourceName(classPath, methodPath);
						
						// Se já existir um 'webResourceName' igual ele passa para a próxima iteração
						if(webResourceNames.contains(webResourceName))
							continue;
						
						System.out.println("<security-constraint>");
						System.out.println("	<web-resource-collection>");
						System.out.printf ("		<web-resource-name>%s</web-resource-name>\n", webResourceName);
						System.out.printf ("		<url-pattern>%s</url-pattern>\n", getUrlPattern(classPath, methodPath));
						System.out.printf ("		<http-method>%s</http-method>\n", getHttpMethod(method));
						System.out.println("	</web-resource-collection>");
						System.out.println("	<auth-constraint>");
						System.out.printf ("		<role-name>%s</role-name>\n", getRoleName(classPath, methodPath));
						System.out.println("	</auth-constraint>");
						System.out.println("</security-constraint>");
						
						webResourceNames.add(webResourceName);
					}
				}
			}
		}
		
		System.out.println("\n\n");
		
		for (Class<?> clazz : classes) {
			if(clazz.getAnnotation(Path.class) != null) {
				String classPath = clazz.getAnnotation(Path.class).value();
				List<String> webResourceNames = new ArrayList<String>();
				for (Method method : clazz.getMethods()) {
					if(method.getAnnotation(Path.class) != null) {
						String methodPath = method.getAnnotation(Path.class).value();
						String webResourceName = getWebResourceName(classPath, methodPath);
						
						// Se já existir um 'webResourceName' igual ele passa para a próxima iteração
						if(webResourceNames.contains(webResourceName))
							continue;
						
						System.out.println("<security-role>");
						System.out.printf ("	<role-name>%s</role-name>\n", getRoleName(classPath, methodPath));
						System.out.println("</security-role>");
						webResourceNames.add(webResourceName);
					}
				}
			}
		}
		
	}
	
	
	
	
	private static String getHttpMethod(Method method) {
		if(method.getAnnotation(GET.class) != null) return "GET";
		if(method.getAnnotation(POST.class) != null) return "POST";
		if(method.getAnnotation(PUT.class) != null) return "PUT";
		if(method.getAnnotation(DELETE.class) != null) return "DELETE";
		if(method.getAnnotation(HEAD.class) != null) return "HEAD";
		if(method.getAnnotation(OPTIONS.class) != null) return "OPTIONS";
		return null;
	}

	private static String getRoleName(String classPath, String methodPath) {
		return new StringBuilder()
		.append("corporativo_")
		.append(classPath.replaceAll("/", ""))
		.append("_")
		.append(formatMethodPath(methodPath))
		.toString();
	}
	
	private static String getUrlPattern(String classPath, String methodPath) {
		return applicationPath.concat(classPath).concat("/").concat(formatMethodPath(methodPath)).concat("/*");
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
	
}
