package ca.by.project_x.persistence.api;

import java.util.List;

import ca.by.project_x.rest.dto.catalog.Product;

public interface IProductService {
	
	List<Product> findAllProducts(Integer pageSize, Integer pageNumber, ProtuctSortType sort);
	
	List<Product> findAllProductsInCategory(Integer pageSize, Integer pageNumber, ProtuctSortType sort);
	
	//TODO:
	void addProductToCategories(Product product, List<Long> categoryIds);
	
	
}
