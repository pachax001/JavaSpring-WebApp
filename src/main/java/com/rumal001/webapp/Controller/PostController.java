package com.rumal001.webapp.Controller;


import com.rumal001.webapp.DTO.PostDTO;
import com.rumal001.webapp.Enums.PostStatus;
import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Models.Post;
import com.rumal001.webapp.Models.Viewer;
import com.rumal001.webapp.Repositories.PostRepository;
import com.rumal001.webapp.Services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/posts")
public class PostController {
    @Autowired
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    // add posts
    @PostMapping(path = "add")
    @Operation(
            description = "Add a new post as a Viewer",
            summary = "A logged in Viewer can add a post",
            responses = {
            @ApiResponse(
                    description = "Success",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Unauthorized / Invalid Token",
                    responseCode = "403"
            )
    }
    )
    public void addPost(@RequestBody Post post, @AuthenticationPrincipal Viewer viewer) {
        post.setViewer(viewer);
        postService.addNewPost(post);

    }
    @PutMapping(path = "approve/{post_id}")
    @Operation(
            description = "Approve a post by a Moderator",
            summary = "A logged-in Moderator can approve a post",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403"),
                    @ApiResponse(description = "Post Not Found", responseCode = "404")
            }
    )
    public ResponseEntity<String> approvePost(@PathVariable("post_id") Long postId,
                                              @AuthenticationPrincipal Moderator moderator) {

        boolean isApproved = postService.approvePost(postId, moderator, PostStatus.APPROVED);

        if (isApproved) {
            return ResponseEntity.ok("Post approved successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found or approval failed.");
        }
    }




}
