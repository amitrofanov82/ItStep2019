package ca.by.project_x.rest.controllers.personal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.rest.dto.users.personal.WishListItem;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/personal/wishlist")
@Slf4j
public class UserActionController {

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addWishListItem(@RequestBody WishListItem newWishListItem) {
        log.debug("new WishListItem add request");
        System.out.println(newWishListItem.toString());
        return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
    }
	
}
