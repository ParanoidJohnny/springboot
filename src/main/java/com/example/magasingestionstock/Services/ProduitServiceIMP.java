package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.*;
import com.example.magasingestionstock.Repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service

public class ProduitServiceIMP implements ProduitService {

ProduitRepository produitRepository;
RayonRepository rayonRepository;
StockRepository stockRepository;
DetailFactureRepository detailFactureRepository;
FournisseurRepository fournisseurRepository;
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


    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
        Produit p = produitRepository.findById(fournisseurId).orElse(null);
        List<Fournisseur> list =p.getFournisseurs();
        if (f != null && p != null) {
            list.add(f);
            p.setFournisseurs(list);
            produitRepository.save(p);
        }
    }

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
     List<Facture> list = detailFactureRepository.findAllByProduit_IdProduitAndFacture_DateFactureIsBetween(idProduit,startDate,endDate);
     Produit p = produitRepository.findById(idProduit).orElse(null);
     float brut=0;
     if (list != null && p != null) {
         for (Facture f:list
              ) {
             for (DetailFacture d : f.getDetailFactures()
                  ) {
                 brut = brut + (d.getQte()*p.getPrixUnitaire());
             }
         }
      return brut;
     }

        return brut;
    }
}
