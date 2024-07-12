package com.manuelmicroservicios.microserviciosmanuel.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.manuelmicroservicios.microserviciosmanuel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manuelmicroservicios.microserviciosmanuel.entities.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.manuelmicroservicios.microserviciosmanuel.modelos.Coche;
import com.manuelmicroservicios.microserviciosmanuel.modelos.Moto;
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
     private UserService userService;


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>>     getMethodName() {
        List<Usuario> usuarios= userService.getAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(usuarios);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerusuarios(@PathVariable Integer id){
        Usuario user  = userService.getUsuarioByid(id);
        if(user !=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/usuarios/create")
    public ResponseEntity<Usuario> crearusuario(@RequestBody Usuario usaurio) {
       Usuario usercreated =  userService.crearUsuario(usaurio);
       return  ResponseEntity.ok(usercreated);

    }

    @GetMapping("/carros/{usuarioId}")
   public ResponseEntity<List<Coche>> listarCoches(@PathVariable ("usuarioID") int id){
    Usuario usario = userService.getUsuarioByid(id);
     if(usario==null){
        ResponseEntity.notFound().build();
     }
     List<Coche> coches= userService.getCoches(id);
     return ResponseEntity.ok(coches);
   }
   @PostMapping("/carros/{usuarioID}")
   public ResponseEntity<Coche> guardarCoche(@PathVariable ("usuarioID") int usuarioId, @RequestBody Coche carro){
    Coche nuevoCoche= userService.saveCoche(usuarioId, carro);
    return ResponseEntity.ok(nuevoCoche);

   }
   @GetMapping("/motos/{usuarioId}")
   public ResponseEntity<List<Moto>> listarMotos(@PathVariable ("usuarioId") int id){
    Usuario usuario=  userService.getUsuarioByid(id);
    if(usuario==null){
        ResponseEntity.notFound().build();
    }
    List<Moto> motos= userService.getMotos(id);
    return ResponseEntity.ok(motos);


   }
    
   @PostMapping("/motos/{usuarioId}")
    public ResponseEntity<Moto> guardarmoto(@PathVariable ("usuarioId") int usuarioId, @RequestBody Moto moto){
        Moto newmoto= userService.saveMoto(usuarioId, moto);
        return ResponseEntity.ok(moto);
    }
    @GetMapping("/todos/{usuarioid}")
    public ResponseEntity<Map<String,Object>> listartodosvehiculos( @PathVariable ("usuarioId") int usuarioID){
        Map<String,Object>  listavehiculos =  userService.getUsuarioAndVehicles(usuarioID);
        return ResponseEntity.ok(listavehiculos);
    }
}
