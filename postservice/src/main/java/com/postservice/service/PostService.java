package com.postservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.postservice.feignInterface.FeignClientComment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class PostService {
    
    @Autowired
    private FeignClientComment feignClientComment;
    public String getCommentMsg(){
        return feignClientComment.getComment();
    }


}
