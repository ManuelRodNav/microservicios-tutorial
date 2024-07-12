package com.vehicleandcar.manuelvehicleandcar.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vehicleandcar.manuelvehicleandcar.Repository.CocheRepository;
import com.vehicleandcar.manuelvehicleandcar.Service.entities.Coche;
import java.util.List;
@Service
public class CocheServicio  {

@Autowired
CocheRepository cocheRepository;

public List<Coche>  getall(){
return cocheRepository.findAll();
}

public Coche  encontrarCoche(int id){
   return  cocheRepository.findById(id).orElse(null);

}
public Coche  crearCoche(Coche coche){
  Coche newCoche =   cocheRepository.save(coche);
  return newCoche;
}
public List<Coche> byUsuarioid( int usuarioID){
   return  cocheRepository.findbyusuario(usuarioID);
}
}
