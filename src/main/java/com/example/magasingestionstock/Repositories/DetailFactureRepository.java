package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.DetailFacture;
import com.example.magasingestionstock.Entities.Facture;
import com.example.magasingestionstock.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {
    List<Facture> findAllByProduit_IdProduitAndFacture_DateFactureIsBetween(Long id, Date start, Date end);

}
