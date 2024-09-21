package com.rumal001.webapp.DTO;

import com.rumal001.webapp.Models.Post;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostDTOMapper implements Function<Post, PostDTO> {
    @Override
    public PostDTO apply(Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),

//                post.getViewer(),
                post.getStatus()
//                post.getModerator()
        );
    }
}
