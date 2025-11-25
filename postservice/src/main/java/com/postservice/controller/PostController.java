package com.postservice.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.postservice.feignInterface.FeignClientComment;
import com.postservice.service.PostService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping("/get")
    public String getComment() {
       return postService.getCommentMsg();
    }
   
    
}
