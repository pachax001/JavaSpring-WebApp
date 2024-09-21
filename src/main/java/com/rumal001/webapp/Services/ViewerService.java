package com.rumal001.webapp.Services;

import com.rumal001.webapp.DTO.ViewerDTO;
import com.rumal001.webapp.DTO.ViewerDTOMapper;
import com.rumal001.webapp.Repositories.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ViewerService {
    private final ViewerRepository viewerRepository;
    private final ViewerDTOMapper viewerDTOMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ViewerService(ViewerRepository viewerRepository, ViewerDTOMapper viewerDTOMapper) {
        this.viewerRepository = viewerRepository;
        this.viewerDTOMapper = viewerDTOMapper;
    }



}
