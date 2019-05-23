package ca.by.project_x.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	private Long id;
	private Long entityId;
	private String type;
    private String text;
    private Long userId;
    private String userName;
    
}
