package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Client;

import java.util.List;

public interface ClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
}
