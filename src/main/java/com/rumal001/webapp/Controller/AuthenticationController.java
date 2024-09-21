package com.rumal001.webapp.Controller;


import com.rumal001.webapp.DTO.AuthenticationRequest;
import com.rumal001.webapp.DTO.AuthenticationResponse;
import com.rumal001.webapp.Enums.Role;
import com.rumal001.webapp.Models.Moderator;
import com.rumal001.webapp.Models.Viewer;
import com.rumal001.webapp.Repositories.ModeratorRepository;
import com.rumal001.webapp.Repositories.ViewerRepository;
import com.rumal001.webapp.Security.JwtUtils;
import com.rumal001.webapp.Security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsImpl userDetailsService;

    @Autowired
    private ViewerRepository viewerRepository;

    @Autowired
    private ModeratorRepository moderatorRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticationRequest request) {
        try {
            String email = request.getEmail();
            Optional<Viewer> viewer = viewerRepository.findByEmailAndDeleted(email, false);
            Optional<Moderator> moderator = moderatorRepository.findByEmailAndDeleted(email, false);
            if (viewer.isEmpty() && moderator.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            }

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, request.getPassword())

            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Role role;
            if (userDetails instanceof Viewer) {
                role = ((Viewer) userDetails).getRole();
            }
            else if (userDetails instanceof Moderator) {
                role = ((Moderator) userDetails).getRole();

            }
            else {
                throw new IllegalStateException("Unknown user type");
            }
            String jwt = jwtUtils.generateToken(userDetails.getUsername(), role.name());
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
