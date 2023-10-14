package com.codingtech.formationcenter.entity;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // constructors, getters, setters
}