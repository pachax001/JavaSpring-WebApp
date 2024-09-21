package com.rumal001.webapp.Repositories;

import com.rumal001.webapp.Models.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    @Query("SELECT m FROM Moderator m WHERE m.email = :email AND m.deleted= :deleted")
    Optional<Moderator> findByEmailAndDeleted(String email, boolean deleted);
}
