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

    private Integer idProfile;

    private Integer position;

    private String url;

    public ImageDTO(@JsonProperty("idProfile") Integer idProfile,
                    @JsonProperty("position") Integer position,
                    @JsonProperty("url") String url) {
        this.idProfile = idProfile;
        this.position = position;
        this.url = url;
    }

    public Image toImageWithoutProfile(){
        Image image = new Image();
        image.setPosition(this.position);
        image.setUrl(this.url);
        return image;
    }

    public Image toImageWithUrl(){
        Image image = new Image();
        image.setUrl(this.url);
        return image;
    }
}
