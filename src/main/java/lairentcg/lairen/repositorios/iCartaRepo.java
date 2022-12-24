package lairentcg.lairen.repositorios;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.entidades.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface iCartaRepo extends JpaRepository <Carta, Long> {

    Optional <Carta> findByNombreCarta(String nombre);

    @Query("SELECT u FROM Carta u ORDER BY nombre_carta ASC")
    List<Carta> traerCartasOrdenarPorNombre();

    List <Carta> findByNombreCartaContaining(String parteNombre);

    List <Carta> findByCosteCarta(Long coste);

    List <Carta> findByExpansion(Expansion expansion);

    List <Carta> findByRareza(Rareza rareza);

    List <Carta> findByTipo(Tipo tipo);

}
