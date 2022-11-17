package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Client;
import com.example.magasingestionstock.Entities.Rayon;

import java.util.List;

public interface RayonService {

    List<Rayon> retrieveAllRayon();
    Rayon addRayon(Rayon c);
    void deleteRayon(Long id);
    Rayon updateRayon(Rayon c);
    Rayon retrieveRayon(Long id);
}
