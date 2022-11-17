package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
