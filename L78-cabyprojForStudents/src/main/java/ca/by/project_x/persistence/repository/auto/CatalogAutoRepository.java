package ca.by.project_x.persistence.repository.auto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.by.project_x.persistence.model.catalog.Label;

@Repository
public interface CatalogAutoRepository extends CrudRepository<Label, Long>{
	
	@Query("FROM Label where parentId = ?1 and isCategory=true")
	List<Label> findCategoriesByParentId(@Param(value = "parentId") Long parentId);
	
	//parameter null is not supported in queries like above :(
	//TODO: we can try this approach later to have single query:
	//https://stackoverflow.com/questions/10802798/spring-data-jpa-query-with-parameter-properties
	@Query("FROM Label where parentId = null and isCategory=true")
	List<Label> findRootCategories();
	
}
