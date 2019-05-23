package ca.by.project_x.rest.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private UserRole role;	
	private Long id;
	private String firstName;
	private String lastName;

}
