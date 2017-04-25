package com.itransition.portfl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Kulik Artur
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArrayTagsDTO {
    private List<TagDTO> tags;

    public ArrayTagsDTO(@JsonProperty("tags") List<TagDTO> tags){
        this.tags = tags;
    }

}
