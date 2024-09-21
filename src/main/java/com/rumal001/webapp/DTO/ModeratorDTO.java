package com.rumal001.webapp.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeratorDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String profileURL;
}
