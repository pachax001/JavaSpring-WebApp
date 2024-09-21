package com.rumal001.webapp.Services;


import com.rumal001.webapp.DTO.ModeratorDTOMapper;
import com.rumal001.webapp.Repositories.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorService {
    private final ModeratorRepository moderatorRepository;
    private final ModeratorDTOMapper moderatorDTOMapper;

    @Autowired
    public ModeratorService(ModeratorRepository moderatorRepository, ModeratorDTOMapper moderatorDTOMapper){
        this.moderatorRepository = moderatorRepository;
        this.moderatorDTOMapper = moderatorDTOMapper;
    }

}
