package com.itransition.portfl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.portfl.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kulik Artur
 */
@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private Integer imageId;

    private String title;

    private Integer position;

    private String text;

    public CommentDTO(@JsonProperty("imageId") Integer imageId,
                      @JsonProperty("title") String title,
                      @JsonProperty("position") Integer position,
                      @JsonProperty("text") String text) {
        this.imageId = imageId;
        this.title = title;
        this.position = position;
        this.text = text;
    }

    public Comment toCommentWithoutImage() {
        Comment comment = new Comment();
        comment.setTitle(this.title);
        comment.setPosition(this.position);
        comment.setText(text);
        return comment;
    }
}
