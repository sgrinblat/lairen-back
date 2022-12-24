package lairentcg.lairen.repositorios;

import lairentcg.lairen.entidades.Rareza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRarezaRepo extends JpaRepository<Rareza, Long> {

    Optional <Rareza> findByNombreRareza(String nombre);
}
