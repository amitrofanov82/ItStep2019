package ca.by.project_x.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.by.project_x.conversion.EntityDtoCoversionUtils;
import ca.by.project_x.persistence.api.ICatalogService;
import ca.by.project_x.persistence.model.catalog.Label;
import ca.by.project_x.persistence.repository.auto.CatalogAutoRepository;
import ca.by.project_x.rest.dto.catalog.Category;

@Service
public class CatalogService /*implements ICatalogService*/ {
	
	@Autowired
	private CatalogAutoRepository catalogRepo;

	//@Override
	public List<Category> findCategoriesByParentId(Long parentId) {
    	List<Label> categoriesDb = null;

    	categoriesDb = parentId == null ? catalogRepo.findRootCategories() : catalogRepo.findCategoriesByParentId(parentId);
    	List<Category> categoriesDto = new ArrayList<>(categoriesDb.size());
    	categoriesDb.forEach((entity) 
    			-> categoriesDto.add(EntityDtoCoversionUtils.categoryToDto(entity)));
    	
        return categoriesDto;
	}
	
}
