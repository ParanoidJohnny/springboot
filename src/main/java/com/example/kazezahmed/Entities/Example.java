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
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exampleId;

    @Temporal(TemporalType.DATE)
    private Date exampleDate;

    @Enumerated(EnumType.STRING)
    private Enum exampleEnum;

    private boolean exampleBoolean;



     /*
     ###############################################################

     // fetch type lazy or eager only in ( Many part of one to many )
     for case where you need to get all stocks and all products in stocks with stock/production one to many
     one to many, many to many = default fetch type lazy
     one to one, many to one  = default fetch is eager

     Entity that manages is the entity that saves the association


     # bidirectional 1 to 1 association (random choice of mapped by)

     in entity 1 : @OneToOne(mappedBy = "detailEquipe")
                   private Equipe equipe;
     in entity 2 : @OneToOne
                   DetailEquipe detailEquipe;

     ###############################################################

     # unidirectional 1 to many association

     in 1 entity : @OneToMany
                   private List<Departement> departements;
     in * entity : nothing

     ###############################################################

     # bidirectional 1 to many association

     in 1 entity : @OneToMany (mappedBy = "departement")
                    private List<Etudiant> etudiants;
     in * entity : @ManyToOne
                    private Departement departement;

     ###############################################################

     # many to many association (Etudiant manages equipe, mapped by will be in managed entity)

     in entity 1 (equipe) : @ManyToMany(mappedBy = "equipe")
                   private List<Etudiant> etudiants;
     in entity 2 (etudiant) : @ManyToMany
                   private List<Equipe> equipe;

     ###############################################################

     # Saving/creating the parent entity will save/create the child entity
       Declaration must be in entity that manages the other entity otherwise both will be created simultaniously but
       wont be linked with each other
      @ManyToOne(cascade = CascadeType.PERSIST)
       private Etudiant etudiant;
     */


}
