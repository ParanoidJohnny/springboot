package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.CategorieClient;
import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {

    List<Facture> findAllByDateFactureIsBetweenAndClientCategorieClient(Date date1, Date date2, CategorieClient cat);


}
