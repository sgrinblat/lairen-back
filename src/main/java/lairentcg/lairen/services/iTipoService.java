package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Tipo;

import java.util.List;
import java.util.Optional;

public interface iTipoService {

    List<Tipo> mostrarTodosLosTipos();

    Optional<Tipo> mostrarTipoPorID(Long id);

    Optional<Tipo> mostrarTipoPorNombre(String nombre);

    Tipo cargarNuevaTipo(Tipo tipo);

    public void eliminarTipoPorId(Long id);

    Tipo actualizarTipo(Long id, Tipo tipo);
}
