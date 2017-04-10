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
@Table(name = "types_of_photography")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TypeOfPhotography {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    public TypeOfPhotography(String text) {
        this.text = text;
    }
}
