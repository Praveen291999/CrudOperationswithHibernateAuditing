package auditing.hibernateEnvers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auditing.hibernateEnvers.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
