package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Stock;
import com.example.magasingestionstock.Repositories.ClientRepository;
import com.example.magasingestionstock.Repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
