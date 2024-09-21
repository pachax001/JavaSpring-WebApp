package com.rumal001.webapp.DTO;

import com.rumal001.webapp.Enums.PostStatus;
import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Models.Viewer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
//    private Viewer viewer;
    private PostStatus status;
//    private Moderator moderator;

}
