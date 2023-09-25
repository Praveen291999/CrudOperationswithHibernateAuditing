package auditing.hibernateEnvers.repository;

import org.springframework.data.repository.CrudRepository;

import auditing.hibernateEnvers.Entity.RequestBodyAuditing;

public interface RequestBodyAuditRepo extends CrudRepository<RequestBodyAuditing,Long>{
	
}
