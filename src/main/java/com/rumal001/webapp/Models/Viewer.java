package com.rumal001.webapp.Models;

import com.rumal001.webapp.Enums.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Viewer extends User implements UserDetails {

    @OneToMany(mappedBy = "viewer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    public Viewer() {
        super();
        this.setRole(Role.VIEWER);
    }

    public Viewer (String firstName, String lastName, String email, String mobile, String password, String profileURL, LocalDateTime createdTimeStamp){
        super(firstName, lastName, email, mobile, password, profileURL, createdTimeStamp);
        this.setRole(Role.VIEWER);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + super.getRole().name()));
    }
    @Override
    public String getPassword() {
        return super.getPassword();
    }
    @Override
    public String getUsername() {
        return super.getEmail();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !super.isDeleted();
    }
}
