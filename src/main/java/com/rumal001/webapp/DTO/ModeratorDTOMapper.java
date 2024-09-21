package com.rumal001.webapp.DTO;

import com.rumal001.webapp.Models.Moderator;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ModeratorDTOMapper implements Function<Moderator, ModeratorDTO> {
    @Override
    public ModeratorDTO apply(Moderator moderator) {
        return new ModeratorDTO(
                moderator.getId(),
                moderator.getFirstName(),
                moderator.getLastName(),
                moderator.getEmail(),
                moderator.getMobile(),
                moderator.getProfileurl()
        );
    }

}
