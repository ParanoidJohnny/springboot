package com.example.magasingestionstock.Controllers;

import com.example.magasingestionstock.Entities.CategorieClient;
import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Facture;
import com.example.magasingestionstock.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/client")
@RestController
public class ClientController {
@Autowired
    ClientService clientService;

    @GetMapping("/getAll")
    public List<Client> getAll() {
        return clientService.retrieveAllClients();
    }
    @PostMapping ("/addClient")
    public Client addClient (@RequestBody Client e) {
        return clientService.addClient(e);
    }

    @PutMapping ("/updateClient")
    public Client updateClient (@RequestBody Client e) {
        return clientService.updateClient(e);
    }

    @GetMapping("/getClient/{id}")
    public Client retrieveClient(@PathVariable(value="id") Long id) {
        return clientService.retrieveClient(id);

    }

    @DeleteMapping("/deleteClient/{id}")
    public void removeClient(@PathVariable(value ="id") Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/factureByClientId/{id}")
    public List<Facture> getFacturesByClient(@PathVariable long id){
        return clientService.getFacturesByClient(id);
    }
    @GetMapping("/chiffreAffaire")
    public float getChiffreAffaireParCategorieClient(@RequestBody CategorieClient categorieClient, Date startDate, Date endDate)
    {
        return clientService.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }

}
