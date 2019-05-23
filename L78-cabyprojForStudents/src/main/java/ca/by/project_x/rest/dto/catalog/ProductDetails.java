package ca.by.project_x.rest.dto.catalog;

import ca.by.project_x.rest.dto.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails{

	private Product product;
	private Double shopReiting;
	private String[] sizes;
	private String material;
	private String[] colors;
	private Boolean isFavorite;
	private String[] allImgUrls;
	private Comment[] comments;

	
}
