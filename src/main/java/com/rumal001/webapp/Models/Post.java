package com.rumal001.webapp.Models;

import com.rumal001.webapp.Enums.PostStatus;
import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Boolean deleted = false;
    private PostStatus status;


    @ManyToOne
    private Viewer viewer;
    @ManyToOne
    private Moderator moderator;

    public Post() {}
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }
}
