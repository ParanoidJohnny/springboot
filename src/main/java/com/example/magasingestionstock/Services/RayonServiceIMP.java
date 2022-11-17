package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Rayon;
import com.example.magasingestionstock.Entities.Rayon;
import com.example.magasingestionstock.Repositories.RayonRepository;
import com.example.magasingestionstock.Repositories.RayonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class RayonServiceIMP implements RayonService {

RayonRepository rayonRepository;

    @Override
    public List<Rayon> retrieveAllRayon() {
        return rayonRepository.findAll();
    }

    @Override
    public Rayon addRayon(Rayon c) {
        return rayonRepository.save(c);
    }

    @Override
    public void deleteRayon(Long id) {
     rayonRepository.deleteById(id);
    }

    @Override
    public Rayon updateRayon(Rayon c) {
        return rayonRepository.save(c);
    }

    @Override
    public Rayon retrieveRayon(Long id) {
        return rayonRepository.findById(id).orElse(null);
    }
}
