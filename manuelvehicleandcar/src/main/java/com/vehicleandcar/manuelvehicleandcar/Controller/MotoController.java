package com.vehicleandcar.manuelvehicleandcar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.vehicleandcar.manuelvehicleandcar.Service.MotoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import com.vehicleandcar.manuelvehicleandcar.Service.entities.Moto;
@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    MotoService motoService;

    @GetMapping("/alls")
    public ResponseEntity<List<Moto>> getalls(){
        List<Moto> motos= motoService.getall();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/alls/{id}")
    public ResponseEntity<Moto> mResponseEntity(@PathVariable ("id") int id){
       Moto moter =  motoService.findbyId(id);
       if(moter == null){
        return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(moter);
        
    }
    @PostMapping("/alls/{id}")
    public ResponseEntity<Moto> postid(@RequestBody Moto moto1){
       Moto moto= motoService.crearMoto(moto1);
       return ResponseEntity.ok(moto);
    }
    }
    

