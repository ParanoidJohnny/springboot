package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.CategorieClient;
import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Facture;
import com.example.magasingestionstock.Repositories.ClientRepository;
import com.example.magasingestionstock.Repositories.FactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service

public class ClientServiceIMP implements ClientService {

ClientRepository clientRepository;
FactureRepository factureRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
      clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client c = clientRepository.findById(idClient).orElse(null);
        if (c != null) {
            return c.getFactures();
        }
        return null;
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {

        float chiffre = 0;
        List<Facture> list = factureRepository.findAllByDateFactureIsBetweenAndClientCategorieClient(startDate,endDate,categorieClient);
        for (Facture f : list)
        {
          chiffre = f.getMontantFacture()+chiffre;
        }
        return chiffre;
    }


}
