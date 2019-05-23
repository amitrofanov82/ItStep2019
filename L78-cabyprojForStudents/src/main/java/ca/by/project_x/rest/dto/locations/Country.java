package ca.by.project_x.rest.dto.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	private String isoAlpha2Code; //like US, is id
	private String isoAlpha3Code; //likeUSA
	private String name; //like USA
	private String fullName; //like United States of America

}
