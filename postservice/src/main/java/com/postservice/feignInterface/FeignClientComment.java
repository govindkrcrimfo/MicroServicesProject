package com.postservice.feignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient ( name="comment-service" , fallback = CommentFallback.class)
public interface FeignClientComment {
    
    @GetMapping("/comment/getComment")
    public String getComment();

}
