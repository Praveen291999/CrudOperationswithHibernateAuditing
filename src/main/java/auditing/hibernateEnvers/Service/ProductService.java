package auditing.hibernateEnvers.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auditing.hibernateEnvers.Entity.Product;
import auditing.hibernateEnvers.Entity.RequestBodyAuditing;
import auditing.hibernateEnvers.repository.ProductRepository;
import auditing.hibernateEnvers.repository.RequestBodyAuditRepo;
import auditing.hibernateEnvers.util.UtilClass;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RequestBodyAuditRepo auditRepo;

	boolean flag = false;
	String operation = null;
	RequestBodyAuditing reqAudit;

	// To inject the EntityManager Interface into the class.
	@PersistenceContext
	private EntityManager entityManager;

	public void createProduct(Product product, HttpServletRequest request, HttpServletResponse response) {
		reqAudit = new RequestBodyAuditing();

		productRepository.save(product);
		operation = "Created Employee with id : " + product.getId();
		UtilClass.saveAuditData(reqAudit, request, operation, response);
		auditRepo.save(reqAudit);
	}

	public Product getProduct(Long id, HttpServletRequest request, HttpServletResponse response) {
		if (productRepository.findById(id).isPresent()) {
			reqAudit = new RequestBodyAuditing();
			operation = "retrieved Employee with id:" + id;
			UtilClass.saveAuditData(reqAudit, request, operation, response);
			auditRepo.save(reqAudit);
			return productRepository.findById(id).get();
		} else
			return null;

	}

	public void updateProduct(Long id, Product updatedProduct, HttpServletRequest request,
			HttpServletResponse response) {
		reqAudit = new RequestBodyAuditing();
		if (productRepository.findById(id).isPresent()) {
			operation = "Updating the Employee with id :" + id;
			UtilClass.saveAuditData(reqAudit, request, operation, response);
			auditRepo.save(reqAudit);
			Product pro = productRepository.findById(id).get();
			if (pro != null) {
				pro.setName(updatedProduct.getName());
				pro.setPrice(updatedProduct.getPrice());
				productRepository.save(pro);
			}
		}
	}

	public void deleteProduct(Long id, HttpServletRequest request, HttpServletResponse response) {
		reqAudit = new RequestBodyAuditing();
		if (productRepository.findById(id).isPresent()) {
			operation = "deleted Employee with id :" + id;
			UtilClass.saveAuditData(reqAudit, request, operation, response);
			auditRepo.save(reqAudit);
			productRepository.deleteById(id);

		}

	}
}
