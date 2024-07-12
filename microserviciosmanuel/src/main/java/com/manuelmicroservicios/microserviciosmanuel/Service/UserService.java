package com.manuelmicroservicios.microserviciosmanuel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.manuelmicroservicios.microserviciosmanuel.entities.Usuario;
import com.manuelmicroservicios.microserviciosmanuel.modelos.Coche;
import com.manuelmicroservicios.microserviciosmanuel.modelos.Moto;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import com.manuelmicroservicios.microserviciosmanuel.Repository.UserRepository;
import com.manuelmicroservicios.microserviciosmanuel.Service.FeignClients.CarroFeignClient;
import com.manuelmicroservicios.microserviciosmanuel.Service.FeignClients.MotoFeignClient;


@Service
public class   UserService {
    @Autowired
   private  UserRepository userRepository;

   @Autowired
   private RestTemplate restTemplate;

   @Autowired
   private CarroFeignClient carroFeignClient;

   @Autowired
   private MotoFeignClient motoFeignClient;

    public List<Coche> getCoches(int usuarioID){
        List<Coche> coches= restTemplate.getForObject("http://localhost:8001/coches/usuario/" + usuarioID, List.class);
        return coches;
    }
   public List<Moto> getMotos(int usuarioID){
    List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario" + usuarioID, List.class);
    return motos;
   }
   public Coche saveCoche(int usuarioID, Coche coche){
    coche.setUsuarioId(usuarioID);
    Coche nuevCoche= carroFeignClient.save(coche);
    return nuevCoche;
   }
   public  Moto saveMoto(int usuarioId, Moto moto){
    moto.setUsuarioId(usuarioId);
    Moto newmoto= motoFeignClient.savMoto(moto);
    return newmoto;
   }

   public Map<String, Object> getUsuarioAndVehicles(int usuarioId){

    Map<String, Object> resultado= new HashMap<>();
    Usuario usuario= userRepository.findById(usuarioId).orElse(null);

    if(usuario==null){
        resultado.put( "Usuario" , "El usuario no existe");
        return resultado;
    }
    else{
    resultado.put("Usuario", usuario);
    }
    List<Coche> coches= carroFeignClient.getCoche(usuarioId);
    if(coches.isEmpty()){
        resultado.put("Carros", "el usuario no tiene coches");
        return resultado;
    }
    else{
    resultado.put("Coches", coches);
    }
    List<Moto> motos= motoFeignClient.getMotos(usuarioId);
    if(motos.isEmpty()){
        resultado.put("Motos", "no tiene  motos");
        return resultado;
    }
    else{
        resultado.put("Motos", motos);
    }
    return resultado;
   }
  






   public List<Usuario>  getAll(){
    return  userRepository.findAll();
   }
   public  Usuario  getUsuarioByid(int id){
   return  userRepository.findById(id).orElse(null);
   }
   public void  eliminarporID(int id){
    userRepository.deleteById(id);
   }
   public Usuario  crearUsuario(Usuario usuario){
    Usuario nUsuario= userRepository.save(usuario);
    return nUsuario;
   }
   
    
}
