package com.example.kazezahmed.Repositories;

import com.example.kazezahmed.Entities.Enum;
import com.example.kazezahmed.Entities.Example;
import com.example.kazezahmed.Entities.Project;
import com.example.kazezahmed.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


   public User findByFirstnameAndLastname(String FName, String LName);


}
