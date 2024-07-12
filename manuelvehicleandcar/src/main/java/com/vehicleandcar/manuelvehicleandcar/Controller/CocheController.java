package com.vehicleandcar.manuelvehicleandcar.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.vehicleandcar.manuelvehicleandcar.Service.CocheServicio;
import com.vehicleandcar.manuelvehicleandcar.Service.entities.Coche;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/coches")
public class CocheController {

    @Autowired
    private CocheServicio cocheServicio;

    @GetMapping("/coches")
    public ResponseEntity<List<Coche>> getallbyid() {
        List<Coche> coche = cocheServicio.getall();
        if (coche.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coche);
    }

    @GetMapping("/coches/{id}")
    public ResponseEntity<Coche> getallbyid(@PathVariable("id") int id) {
        Coche coche = cocheServicio.encontrarCoche(id);
        if (coche == null) {
          return   ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coche);

    }

    @PostMapping("/coches")
    public ResponseEntity<Coche> guardarcoche(@RequestBody Coche coche) {
        Coche coch = cocheServicio.crearCoche(coche);
        return ResponseEntity.ok(coch);
    }

    @GetMapping("/usuario/{usuarioId}") 
    public ResponseEntity<List<Coche>> buscaruserid(@PathVariable("usuarioId") int usuarioId) {
        List<Coche> coches= cocheServicio.byUsuarioid(usuarioId);
        if(coches.isEmpty()){
          return   ResponseEntity.noContent().build();
        }
       return  ResponseEntity.ok(coches);
    }
}
