package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Facture;

import java.util.List;

public interface FactureService {


    List<Facture> retrieveAllFactures();

    void cancelFacture(Long id);

    Facture retrieveFacture(Long id);
}
