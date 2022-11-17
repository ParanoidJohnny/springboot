package com.example.magasingestionstock.Controllers;

import com.example.magasingestionstock.Entities.Produit;
import com.example.magasingestionstock.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/produit")
@RestController
public class ProduitController {
@Autowired
ProduitService produitService;
        


    @GetMapping("/getAll")
    public List<Produit> getAll() {
return produitService.retrieveAllProduits();
    }
    @PostMapping ("/addProduit/{idRayon}/{idStock}")
    public Produit addProduit (@RequestBody Produit e,@PathVariable long idStock , @PathVariable long idRayon) {
        return produitService.addProduit(e,idRayon,idStock);
    }
    @GetMapping("/getProduit/{id}")
    public Produit retrieveProduit(@PathVariable(value="id") Long id) {
        return produitService.retrieveProduit(id);

    }

    @PutMapping("/assign/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable long idProduit,@PathVariable long idStock) {
         produitService.assignProduitToStock(idProduit,idStock);
    }



}
