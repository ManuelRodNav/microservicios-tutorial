package com.manuelmicroservicios.microserviciosmanuel.Service.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.manuelmicroservicios.microserviciosmanuel.modelos.Moto;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "moto-service",  url="http://localhost:8003")
public interface MotoFeignClient {

    @PostMapping("/")
    public Moto savMoto(@RequestBody Moto moto);

    @GetMapping("/usuario/moto/{usuarioId}")
    public List<Moto> getMotos(@PathVariable ( "usuarioId") int usuarioId);
}
