package com.codingtech.formationcenter.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

}