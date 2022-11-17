package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.CategorieClient;
import com.example.magasingestionstock.Entities.CategorieProduit;
import com.example.magasingestionstock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
