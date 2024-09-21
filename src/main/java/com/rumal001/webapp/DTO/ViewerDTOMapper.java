package com.rumal001.webapp.DTO;

import com.rumal001.webapp.Models.Viewer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ViewerDTOMapper implements Function<Viewer, ViewerDTO> {
    @Override
    public ViewerDTO apply(Viewer viewer) {
        return new ViewerDTO(
                viewer.getId(),
                viewer.getFirstName(),
                viewer.getLastName(),
                viewer.getEmail(),
                viewer.getMobile(),
                viewer.getRole(),
                viewer.getProfileurl()
        );
    }
}
