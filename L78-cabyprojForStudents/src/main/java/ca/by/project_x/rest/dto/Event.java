package ca.by.project_x.rest.dto;


import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	private ZonedDateTime dateTime;
    private String name;
    private String description;
    
}
