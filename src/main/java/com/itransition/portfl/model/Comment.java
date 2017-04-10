package com.itransition.portfl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Artur on 09.04.2017.
 */
@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_image")
    private Image image;

    @Column(name = "position")
    private Integer position;

    @Column(name = "text")
    private String text;

    public Comment(Image imege, Integer position, String text) {
        this.image = image;
        this.position = position;
        this.text = text;
    }
}
