package com.example.magasingestionstock.Services;

import com.example.magasingestionstock.Entities.Facture;
import com.example.magasingestionstock.Repositories.FactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class FactureServiceIMP implements FactureService {

FactureRepository   factureRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {;
        Facture f = factureRepository.findById(id).orElse(null);
        f.setActive(false);
        factureRepository.save(f);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).orElse(null);
    }
}
