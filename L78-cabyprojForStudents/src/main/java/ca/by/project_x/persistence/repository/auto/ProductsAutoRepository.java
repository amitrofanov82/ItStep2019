package ca.by.project_x.persistence.repository.auto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import ca.by.project_x.persistence.model.catalog.Product;
import ca.by.project_x.persistence.model.catalog.ProductImage;



public interface ProductsAutoRepository extends PagingAndSortingRepository<Product, Long>{
	
	Page<Product> findAll(Pageable pageable);

	@Query("Select p FROM Product p JOIN p.categories l where l.id = :categoryId")
	Page<Product> findByCategoryId(@Param(value = "categoryId") Long categoryId, Pageable pageable);
	

	@Query("Select pi FROM ProductImage pi where pi.product.id = :productId")
	List<ProductImage> findImagesByProductId(@Param(value = "productId") Long productId);
	
}
