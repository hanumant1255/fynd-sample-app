package com.shindeh.springboot.fynd.controllers;

import com.shindeh.springboot.fynd.model.Comment;
import com.shindeh.springboot.fynd.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    Comment getComment(@PathVariable Long id){
        return  commentService.findById(id).get();
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    String addComment(@RequestBody Comment comment){
        Comment savedComment = commentService.save(comment);
        return "SUCCESS";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    Comment updateComment(@RequestBody Comment comment){
        Comment updateComment = commentService.save(comment);
        return updateComment;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.DELETE)
    Map<String, String> deleteComment(@RequestParam Long id){
        Map<String, String> status = new HashMap<>();
        Optional<Comment> comment = commentService.findById(id);
        if(comment.isPresent()) {
            commentService.delete(comment.get());
            status.put("Status", "Comment deleted successfully");
        }
        else {
            status.put("Status", "Comment not exist");
        }
        return status;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    List<Comment> getAllComments(){
        return commentService.findAll();
    }

}
