package lairentcg.lairen.repositorios;

import lairentcg.lairen.entidades.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iExpansionRepo extends JpaRepository<Expansion, Long> {

    Optional <Expansion> findByNombreExpansion(String nombre);
}
