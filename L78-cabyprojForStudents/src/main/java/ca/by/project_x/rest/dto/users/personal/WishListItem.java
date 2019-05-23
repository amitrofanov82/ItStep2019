package ca.by.project_x.rest.dto.users.personal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListItem {
	
	private String type;
	private Long entityId;
	private Long userId;

}
