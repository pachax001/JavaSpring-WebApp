package com.rumal001.webapp.Repositories;

import com.rumal001.webapp.Enums.PostStatus;
import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Models.Post;
import com.rumal001.webapp.Models.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.status = :status, p.moderator = :moderator WHERE p.id = :id")
    int updatePostStatusAndModerator(@Param("status")PostStatus status, @Param("id") Long id, @Param("moderator")Moderator moderator);

    @Query("SELECT p FROM Post p WHERE p.deleted = :deleted AND p.status = :status AND p.viewer = :viewer")
    List<Post> findByDeletedAndStatusAndViewer(@Param("deleted") boolean deleted, @Param("status") PostStatus status, @Param("viewer")Viewer viewer);



}
