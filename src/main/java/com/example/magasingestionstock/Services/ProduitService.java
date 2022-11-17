package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Produit;

import java.util.List;

public interface ProduitService {

    List<Produit> retrieveAllProduits();
    Produit addProduit(Produit p, Long idRayon, Long idStock);
    Produit retrieveProduit(Long id);
    void assignProduitToStock(Long idProduit, Long idStock);
}
