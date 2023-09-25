package auditing.hibernateEnvers.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Audited
@Data
public class RequestBodyAuditing {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String currentUser;
		private String userAgent;
		private String url;
		private String method;
		private String requestURI;
		private String protocol;
		private String remoteHost;
		private LocalDateTime createdone;
		private String contentType;
		private String acceptLanguage;
		private String operation;
		private String remoteAddress;
		private String remotePort;
		private String operatingSystem;
		private int status;
		

}
