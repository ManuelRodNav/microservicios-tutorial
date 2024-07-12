package com.vehicleandcar.manuelvehicleandcar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.vehicleandcar.manuelvehicleandcar.Service.entities.Coche;


@Repository
public interface CocheRepository  extends JpaRepository<Coche,Integer>{
List<Coche> findbyusuario(int usuarioID);
    
} 
