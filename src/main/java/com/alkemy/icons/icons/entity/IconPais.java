package com.alkemy.icons.icons.entity;

import javax.persistence.*;

@Entity
public class IconPais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "icon_id")
    private Long iconId;

    @Column(name = "pais_id")
    private Long paisId;
}
