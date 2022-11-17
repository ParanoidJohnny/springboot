package com.example.magasingestionstock.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;
    private int qte;
    private Float prixTotal;
    private int pourcentageRemise;
    private int montantRemise;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Facture facture;


}
