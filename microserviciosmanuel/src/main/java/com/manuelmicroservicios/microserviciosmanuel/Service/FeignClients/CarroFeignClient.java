package com.manuelmicroservicios.microserviciosmanuel.Service.FeignClients;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.manuelmicroservicios.microserviciosmanuel.modelos.Coche;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "CocheService" , url = "http://localhost:8001")
@RequestMapping("/car")
public interface  CarroFeignClient {

    @PostMapping
    public Coche save( @RequestBody Coche coche );


    @GetMapping("/usuario/coches/{usuarioId}")
    public List<Coche> getCoche(@PathVariable ("usuarioId") int usuarioId);
}


