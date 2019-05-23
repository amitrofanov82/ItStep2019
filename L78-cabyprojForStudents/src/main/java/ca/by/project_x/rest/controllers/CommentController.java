package ca.by.project_x.rest.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.rest.dto.Comment;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/social/comment")
@Slf4j
public class CommentController {
	
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getComment(@RequestParam(required=false) Integer maxSize, @RequestParam String type,
    		@RequestParam(required=false) Integer page, @RequestParam Integer skip, @RequestParam Long entityId) {
    	log.debug("get comments method");
    	List<Comment> comments = new ArrayList<>(2);
        Comment comment1 = new Comment(new Long(1),entityId ,type, "It's good product. I'm great!", new Long(1), "Kolia");
        Comment comment2 = new Comment(new Long(2),entityId ,type, "NonPenisCanina", new Long(2), "Vasia");
                
        comments.addAll(Arrays.asList(new Comment[] {comment1, comment2}));
    	   	
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    
   
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addComment(@RequestBody Comment newComment) {
        log.debug("new comment add request");
        System.out.println(newComment.toString());
        return new ResponseEntity<>("{\"result\":\"success\"}", HttpStatus.OK);
    }

}
