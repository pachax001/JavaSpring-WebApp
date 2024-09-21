package com.rumal001.webapp.DTO;

import com.rumal001.webapp.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Role role;
    private String profileURL;
}
