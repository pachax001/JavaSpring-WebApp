package com.rumal001.webapp.Controller;


import com.rumal001.webapp.DTO.PostDTO;
import com.rumal001.webapp.Enums.PostStatus;
import com.rumal001.webapp.Models.Viewer;
import com.rumal001.webapp.Services.PostService;
import com.rumal001.webapp.Services.ViewerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/viewer")
public class ViewerController {
    private final ViewerService viewerService;
    private final PostService postService;

    @Autowired
    public ViewerController(ViewerService viewerService, PostService postService) {
        this.viewerService = viewerService;
        this.postService = postService;
    }
    // Get Approved Posts
    @GetMapping(path = "getpostsapproved")
    @Operation(
            description = "Get Approved Posts of a spsecific user",
            summary = "A logged in Viewer can see all the approved posts",
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
    public List<PostDTO> getApprovedPosts(@AuthenticationPrincipal Viewer viewer) {
        return postService.getApprovedPostsOfAUser(viewer, PostStatus.APPROVED);


    }

}
