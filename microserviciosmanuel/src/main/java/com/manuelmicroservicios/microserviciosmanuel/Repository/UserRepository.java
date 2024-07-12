package com.manuelmicroservicios.microserviciosmanuel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuelmicroservicios.microserviciosmanuel.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{

    
} 
