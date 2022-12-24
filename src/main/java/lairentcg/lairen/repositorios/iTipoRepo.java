package lairentcg.lairen.repositorios;

import lairentcg.lairen.entidades.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iTipoRepo extends JpaRepository<Tipo, Long> {

    Optional <Tipo> findByNombreTipo(String nombre);
}
