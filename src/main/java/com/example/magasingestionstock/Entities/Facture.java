package com.example.magasingestionstock.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private Float montantRemise;
    private Float montantFacture;
    private Boolean active;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy="facture")
    private List<DetailFacture> detailFactures;

}
