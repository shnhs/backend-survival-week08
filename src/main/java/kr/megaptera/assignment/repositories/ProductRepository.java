package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductId> {

}
