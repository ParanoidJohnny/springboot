package com.example.magasingestionstock.Repositories;

import com.example.magasingestionstock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
