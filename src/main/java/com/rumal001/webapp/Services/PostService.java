package com.rumal001.webapp.Services;

import com.rumal001.webapp.DTO.PostDTO;
import com.rumal001.webapp.DTO.PostDTOMapper;
import com.rumal001.webapp.Enums.PostStatus;
import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Models.Post;
import com.rumal001.webapp.Models.Viewer;
import com.rumal001.webapp.Repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostDTOMapper postDTOMapper;

    @Autowired
    public PostService(PostRepository postRepository, PostDTOMapper postDTOMapper) {
        this.postRepository = postRepository;
        this.postDTOMapper = postDTOMapper;
    }
    public void addNewPost(Post post) {
        postRepository.save(post);
    }
    @Transactional
    public boolean approvePost(Long postId, Moderator moderator, PostStatus status) {
        if (moderator == null) {
            throw new IllegalStateException("Moderator cannot be null.");
        }
       int updatedRows = postRepository.updatePostStatusAndModerator(status, postId, moderator);

       if (updatedRows == 0) {
           throw new IllegalStateException("Post Not Found!!!");
       }
        return true;
    }

    public List<PostDTO> getApprovedPostsOfAUser(Viewer viewer, PostStatus status) {

        List<Post> posts = postRepository.findByDeletedAndStatusAndViewer(false, status, viewer);

        return posts.stream().map(postDTOMapper).collect(Collectors.toList());

    }
}
