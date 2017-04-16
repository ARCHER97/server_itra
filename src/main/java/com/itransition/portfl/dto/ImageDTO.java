package com.itransition.portfl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.portfl.model.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kulik Artur
 */
@Getter
@Setter
@NoArgsConstructor
public class ImageDTO {

    private Integer idImage;

    private Integer position;

    private String url;

    public ImageDTO(@JsonProperty("idImage") Integer idImage,
                    @JsonProperty("position") Integer position,
                    @JsonProperty("url") String url) {
        this.idImage = idImage;
        this.position = position;
        this.url = url;
    }

    public Image toImageWithoutUser(){
        Image image = new Image();
        image.setPosition(this.position);
        image.setUrl(this.url);
        return image;
    }
}
