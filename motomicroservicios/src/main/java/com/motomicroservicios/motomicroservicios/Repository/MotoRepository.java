package com.motomicroservicios.motomicroservicios.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.motomicroservicios.motomicroservicios.Service.entities.Moto;
import java.util.List;

@Repository
public interface  MotoRepository extends JpaRepository<Moto,Integer> {
    List<Moto> findbyUsuario(int usuarioId);
}
