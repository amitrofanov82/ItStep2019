package ca.by.project_x.rest.dto.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	private Long id;
	private Country country;
	private District district;
	private String name; //Like New York
	private String type; //Like city

}
