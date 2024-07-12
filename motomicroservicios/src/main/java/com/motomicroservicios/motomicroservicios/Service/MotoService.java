package com.motomicroservicios.motomicroservicios.Service;
import com.motomicroservicios.motomicroservicios.Repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.motomicroservicios.motomicroservicios.Service.entities.Moto;
import java.util.List;
@Service
public class MotoService {
@Autowired
MotoRepository motoRepository;

public List<Moto> getall(){
    return motoRepository.findAll();
}
public Moto findbyId(int id){
return motoRepository.findById(id).orElse(null);
}
public Moto crearMoto(Moto moto){
    Moto newmoto= motoRepository.save(moto);
    return newmoto; 
}
public List<Moto> byUsuarioid(int usuarioId){
    return motoRepository.findbyUsuario(usuarioId);
}
    
} 