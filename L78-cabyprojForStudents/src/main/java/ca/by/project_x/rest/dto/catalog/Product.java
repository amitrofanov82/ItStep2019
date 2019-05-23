package ca.by.project_x.rest.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
		
	private Long id;
    private String category;
    private String shop;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    
}
