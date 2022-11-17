package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.Facture;
import com.example.magasingestionstock.Entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RayonRepository extends JpaRepository<Rayon,Long> {
}
