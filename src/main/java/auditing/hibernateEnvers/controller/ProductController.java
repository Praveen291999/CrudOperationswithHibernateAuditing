package auditing.hibernateEnvers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import auditing.hibernateEnvers.Entity.Product;
import auditing.hibernateEnvers.Entity.RequestBodyAuditing;
import auditing.hibernateEnvers.Service.ProductService;
import auditing.hibernateEnvers.repository.RequestBodyAuditRepo;

@RestController
public class ProductController {
	@Autowired
    private ProductService productService;
	
	@Autowired
	private  RequestBodyAuditRepo auditRepo;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product,HttpServletRequest request,HttpServletResponse response) {
        productService.createProduct(product,request,response);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id ,HttpServletRequest request,HttpServletResponse response) {
        return productService.getProduct(id,request,response);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product ,HttpServletRequest request,HttpServletResponse response) {
        productService.updateProduct(id, product,request,response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id ,HttpServletRequest request,HttpServletResponse response) {
        productService.deleteProduct(id,request,response);
    }
    @GetMapping("/getAuditData")
	public ResponseEntity<Iterable<RequestBodyAuditing>> getAuditData() {
		return new ResponseEntity<>(auditRepo.findAll(), HttpStatus.OK);
	}

}
