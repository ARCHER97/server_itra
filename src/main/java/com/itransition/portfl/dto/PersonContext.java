package com.itransition.portfl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kulik Artur
 */
@Getter
@Setter
@NoArgsConstructor
public class PersonContext{
    private UserDTO userDTO;
    private ProfileDTO profileDTO;
    public PersonContext(@JsonProperty("user") UserDTO userDTO,
                         @JsonProperty("profile") ProfileDTO profileDTO){
        this.userDTO = userDTO;
        this.profileDTO = profileDTO;
    }
}
