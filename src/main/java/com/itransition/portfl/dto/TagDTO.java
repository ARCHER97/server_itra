package com.itransition.portfl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.portfl.model.ImagesTags;
import com.itransition.portfl.model.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kulik Artur
 */
@Getter
@Setter
@NoArgsConstructor
public class TagDTO {
    private Integer idImage;
    private String text;

    public TagDTO(@JsonProperty("idImage") Integer idImage,
                  @JsonProperty("text") String text){
        this.idImage = idImage;
        this.text = text;
    }

    public Tag toTag(){
        Tag tag = new Tag();
        tag.setText(this.text);
        return tag;
    }

    public ImagesTags getVoidImagesTags(){
        ImagesTags imagesTags = new ImagesTags();
        return imagesTags;
    }
}
