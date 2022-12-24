package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Rareza;

import java.util.List;
import java.util.Optional;

public interface iRarezaService {

    List<Rareza> mostrarTodasLasRarezas();

    Optional<Rareza> mostrarRarezaPorID(Long id);

    Optional<Rareza> mostrarRarezaPorNombre(String nombre);

    Rareza cargarNuevaRareza(Rareza rareza);

    public void eliminarRarezaPorId(Long id);

    Rareza actualizarRareza(Long id, Rareza rareza);
}
