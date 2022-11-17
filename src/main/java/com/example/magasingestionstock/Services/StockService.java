package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Stock;

import java.util.List;

public interface StockService {

    List<Stock> retrieveAllStock();
    Stock addStock(Stock c);
    void deleteStock(Long id);
    Stock updateStock(Stock c);
    Stock retrieveStock(Long id);
}
