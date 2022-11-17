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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private Float prixUnitaire;
    @ManyToOne
    private Rayon rayon;
    @ManyToOne
    private Stock stock;
    @ManyToMany
    private List<Fournisseur> fournisseurs;
    @OneToOne(cascade = CascadeType.PERSIST)
    private DetailProduit detailProduit;
    @OneToMany(mappedBy = "produit")
    private List<DetailFacture> detailFacture;


}
