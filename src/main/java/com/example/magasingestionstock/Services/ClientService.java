package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.CategorieClient;
import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Facture;

import java.util.Date;
import java.util.List;

public interface ClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);

    List<Facture> getFacturesByClient(Long idClient);

    float getChiffreAffaireParCategorieClient(
            CategorieClient categorieClient, Date startDate, Date endDate);
}
