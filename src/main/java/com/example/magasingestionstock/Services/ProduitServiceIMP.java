package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Produit;
import com.example.magasingestionstock.Entities.Rayon;
import com.example.magasingestionstock.Entities.Stock;
import com.example.magasingestionstock.Repositories.ProduitRepository;
import com.example.magasingestionstock.Repositories.RayonRepository;
import com.example.magasingestionstock.Repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class ProduitServiceIMP implements ProduitService {

ProduitRepository produitRepository;
RayonRepository rayonRepository;
StockRepository stockRepository;
    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
       Rayon r = rayonRepository.findById(idRayon).orElse(null);
       Stock s = stockRepository.findById(idStock).orElse(null);

       p.setRayon(r);
       p.setStock(s);
       produitRepository.save(p);
       return (p);

    }


    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Stock s = stockRepository.findById(idStock).orElse(null);
        Produit p = produitRepository.findById(idProduit).orElse(null);
        if (p != null && s !=null) {
            p.setStock(s);
            produitRepository.save(p);
        }
    }
}
