package ca.by.project_x.persistence.api;

import java.util.List;
import org.springframework.data.repository.query.Param;
import ca.by.project_x.rest.dto.catalog.Category;

public interface ICatalogService {
	
	/**
	 * Returns list of categories by parent Id. 
	 * In case parent Id is null or empty it returns root categories list 
	*/
	List<Category> findCategoriesByParentId(Long parentId);
	
}
