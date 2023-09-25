package auditing.hibernateEnvers.util;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auditing.hibernateEnvers.Entity.RequestBodyAuditing;
import lombok.experimental.UtilityClass;
@UtilityClass
public class UtilClass {
	public static void saveAuditData(RequestBodyAuditing reqAudit, HttpServletRequest request, String operation, HttpServletResponse response) {

		String url = request.getRequestURL().toString();
		int remotePort = request.getRemotePort(); 
		reqAudit.setRemotePort(Integer.toString(remotePort));
		reqAudit.setAcceptLanguage(request.getHeader("Accept-Language"));
		reqAudit.setContentType(request.getContentType());
		reqAudit.setProtocol(request.getProtocol());
		reqAudit.setRemoteHost(request.getRemoteHost());
		reqAudit.setRemoteAddress(request.getRemoteAddr());
		reqAudit.setUrl(url);
		reqAudit.setRequestURI(request.getRequestURI());
		reqAudit.setMethod(request.getMethod());
		reqAudit.setUserAgent(request.getHeader("User-Agent"));
		reqAudit.setOperation(operation);
		reqAudit.setCreatedone(LocalDateTime.now());
		reqAudit.setCurrentUser(System.getProperty("user.name"));
		reqAudit.setOperatingSystem(request.getHeader("sec-ch-ua-platform"));
		reqAudit.setStatus(response.getStatus());
	}

}
