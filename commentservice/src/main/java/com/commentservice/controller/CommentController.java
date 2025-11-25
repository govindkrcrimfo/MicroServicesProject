package com.commentservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @GetMapping("/getComment")
    public String getComments(){
        System.out.println("Hello from comment service");
        return "Hello from comment service !!";
    }
}
