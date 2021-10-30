package com.shindeh.springboot.fynd.controllers;

import com.shindeh.springboot.fynd.model.Blog;
import com.shindeh.springboot.fynd.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;


    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    Blog getBlog(@PathVariable Long id){
        return  blogService.findById(id).get();
    }

    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    String addBlog(@RequestBody Blog blog){
        Blog savedEmployee = blogService.save(blog);
        return "SUCCESS";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.PUT)
    Blog updateBlog(@RequestBody Blog blog){
        Blog updateBlog = blogService.save(blog);
        return updateBlog;
    }

    @RequestMapping(value = "/blog", method = RequestMethod.DELETE)
    Map<String, String> deleteBlog(@RequestParam Long id){
        Map<String, String> status = new HashMap<>();
        Optional<Blog> blog = blogService.findById(id);
        if(blog.isPresent()) {
            blogService.delete(blog.get());
            status.put("Status", "Blog deleted successfully");
        }
        else {
            status.put("Status", "Blog not exist");
        }
        return status;
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    List<Blog> getAllBlogs(){
        return blogService.findAll();
    }

}
