package ca.by.project_x.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.exception.GenericBackendException;
import ca.by.project_x.persistence.api.ICatalogService;
import ca.by.project_x.rest.dto.catalog.Category;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/catalog/category")
@Slf4j
public class CatalogCategoryController {
	
	@Autowired
	private ICatalogService catalogSv;
	
	/**
	 * Returns list of categories by parent Id. 
	 * In case parent Id is null or empty it returns root categories list.<br> 
	 * Filters are not supported at the moment, parameter is left for compatibility with previously set API design. 
	 */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategoriesBy(@RequestParam(required=false) Long parentId, 
    		@RequestParam(required=false, defaultValue = "false") Boolean includeFilters) {
    	log.debug("get catalog categories by parentId HTTP request");
    	if (includeFilters == true) {
    		throw new GenericBackendException("Filters not supported yet");
    	}
    	
    	if ("null".equals(parentId) || "".equals(parentId)) {
    		parentId = null; 
    	}
    	
    	List<Category> categoriesDto = catalogSv.findCategoriesByParentId(parentId);
        return new ResponseEntity<>(categoriesDto, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCategory(@RequestBody Category newCategory) {
        throw new GenericBackendException("Adding/updating new categories via REST API is not supported at MVP");
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCategory(@RequestBody Category newCategory) {
        throw new GenericBackendException("Adding/updating new categories via REST API is not supported at MVP");
    }
    
    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, path="/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
    	throw new GenericBackendException("Adding/updating new categories via REST API is not supported at MVP");
    }

}
