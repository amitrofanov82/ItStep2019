package ca.by.project_x.rest.dto.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** state, province, oblast'... */ 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
	private String name; //like Washington
	private String standardCode; //like WA
	private String type; //like state, or province for Canada
}
