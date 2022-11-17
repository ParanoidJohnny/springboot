package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Produit;
import com.example.magasingestionstock.Entities.Stock;
import com.example.magasingestionstock.Repositories.ClientRepository;
import com.example.magasingestionstock.Repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class StockServiceIMP implements StockService {

StockRepository stockRepository;

    @Override
    public List<Stock> retrieveAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock c) {
        return stockRepository.save(c);
    }

    @Override
    public void deleteStock(Long id) {
      stockRepository.deleteById(id);
    }

    @Override
    public Stock updateStock(Stock c) {
        return stockRepository.save(c);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    @Scheduled(cron = "0 0 22 * * * ")
    public List<Produit> retrieveStatusStock() {
        List<Produit> listproduit = new ArrayList<Produit>();
     List<Stock> liststock = stockRepository.findAll();
        for (Stock s:liststock
             ) {
            if (s.getQteStock()<s.getQteMin()){
                listproduit.addAll(s.getProduits());
            }
        }
        System.out.println(listproduit);
        return listproduit;
    }
}
