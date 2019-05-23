package ca.by.project_x.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.rest.dto.users.SessionInfo;
import ca.by.project_x.rest.dto.users.User;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        //TODO: user by id после авторизации
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="session")
    public ResponseEntity<SessionInfo> getSession(@RequestHeader(name="Authorisation") String jwtToken) {
        //TODO: jwt token can befound at http headers. Смотри документацию, полноценно реализовать можно будет 
    	//после авторизации. 
        return new ResponseEntity<>(new SessionInfo(), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, path="session")
    public ResponseEntity<Void> updateSession(@RequestBody SessionInfo sessionInfo) {
        //TODO: jwt token can befound at http headers. Смотри документацию, полноценно реализовать можно будет 
    	//после авторизации.
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
