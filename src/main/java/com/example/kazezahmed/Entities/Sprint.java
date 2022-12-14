package com.example.kazezahmed.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date startDate;


    //Zid CASCADE TYPE PERSIST F SPRINT W F PROJET EZOUZ

    @ManyToOne
    private Project project;
}
