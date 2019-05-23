package ca.by.project_x.conversion;

import ca.by.project_x.persistence.model.catalog.Label;
import ca.by.project_x.rest.dto.catalog.Category;
import ca.by.project_x.rest.dto.catalog.Shop;

public class EntityDtoCoversionUtils {
	
	public static Category categoryToDto(Label entity){
		Category dto = new Category();
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setImgUrl(entity.getImgUrl());
		dto.setName(entity.getName());
		dto.setParentId(entity.getParentId());
		
		return dto;
	}

	
	//TODO: looks ugly for now and not finished
	public static ca.by.project_x.rest.dto.catalog.Product 
		categoryToDto(ca.by.project_x.persistence.model.catalog.Product entity) {
		ca.by.project_x.rest.dto.catalog.Product dto = new ca.by.project_x.rest.dto.catalog.Product();
		
		dto.setCategory(entity.getCategories().get(0).getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(((double)entity.getPrice())/100);
		
		if (entity.getShop() != null) {
			dto.setShop(entity.getShop().getName());
		} else {
			dto.setShop(null);
		}
		
		if (entity.getProductImages() != null && !entity.getProductImages().isEmpty()) {
			dto.setImgUrl(entity.getProductImages().get(0).getImageLink());
		} else {
			dto.setImgUrl(null);
		}
		return dto;
	}
	
}
