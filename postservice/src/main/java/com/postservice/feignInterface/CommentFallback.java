package com.postservice.feignInterface;

import org.springframework.stereotype.Component;

@Component
public class CommentFallback implements FeignClientComment {

    @Override
    public String getComment() {
        return "Comment service is DOWN! Please try later.";
    }

}
