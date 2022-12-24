package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Expansion;

import java.util.List;
import java.util.Optional;

public interface iExpansionService {

    List<Expansion> mostrarTodasLasExpansiones();

    Optional<Expansion> mostrarExpansionPorID(Long id);

    Optional<Expansion> mostrarExpansionPorNombre(String nombre);

    Expansion cargarNuevaExpansion(Expansion expansion);

    public void eliminarExpansionPorId(Long id);

    Expansion actualizarExpansion(Long id, Expansion expansion);
}
