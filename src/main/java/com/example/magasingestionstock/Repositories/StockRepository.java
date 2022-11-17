package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.Produit;
import com.example.magasingestionstock.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {
}