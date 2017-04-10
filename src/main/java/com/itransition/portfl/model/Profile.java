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
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "col_like")
    private Integer colLike;

    public Profile(User user, Double rating, Integer colLike) {
        this.user = user;
        this.rating = rating;
        this.colLike = colLike;
    }
}
