package com.rumal001.webapp.Repositories;


import com.rumal001.webapp.Models.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
    @Query("SELECT v FROM Viewer v WHERE v.email = :email AND v.deleted= :deleted")
    Optional<Viewer> findByEmailAndDeleted(String email, boolean deleted);

}
