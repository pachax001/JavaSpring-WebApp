package com.rumal001.webapp.Security;


import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Models.Viewer;
import com.rumal001.webapp.Repositories.ModeratorRepository;
import com.rumal001.webapp.Repositories.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private ViewerRepository viewerRepository;
    @Autowired
    private ModeratorRepository moderatorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Viewer viewer = viewerRepository.findByEmailAndDeleted(email,false).orElse(null);
        Moderator moderator = moderatorRepository.findByEmailAndDeleted(email,false).orElse(null);
        if (viewer != null) {
            return  viewer;
        }
        else if (moderator != null) {
            return moderator;
        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
