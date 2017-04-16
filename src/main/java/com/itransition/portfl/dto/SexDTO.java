package com.itransition.portfl.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kulik Artur
 */
@Getter
@Setter
@NoArgsConstructor
public class SexDTO {
    private int id;
    private String name;

    public SexDTO(String name) {
        this.name = name;
    }
}
