package com.rumal001.webapp.Models;

import com.rumal001.webapp.Enums.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Moderator extends User implements UserDetails {
    @OneToMany(mappedBy = "moderator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<Post>();
    public Moderator() {
        super();
        this.setRole(Role.MODERATOR);
    }
    public Moderator(String firstName, String lastName, String email, String mobile, String password, String profileURL){
        super(firstName, lastName, email, mobile, password, profileURL);
        this.setRole(Role.MODERATOR);

    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + super.getRole().name()));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
