package ca.by.project_x.rest.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	private Long id;
	private Long parentId;
    private String name;
    private String description;
    private String imgUrl;
}
