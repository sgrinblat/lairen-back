package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.entidades.Tipo;

import java.util.List;
import java.util.Optional;

public interface iCartaService {

    List<Carta> mostrarTodasLasCartas();

    List<Carta> mostrarPorNombreOrdenado();

    Optional<Carta> mostrarCartaPorID(Long id);

    Optional<Carta> mostrarCartaPorNombre(String nombre);

    List<Carta> mostrarPorParteDelNombre(String nombre);

    List<Carta> mostrarCartasPorCoste(Long coste);

    List<Carta> mostrarCartasPorExpansion(Expansion expansion);

    List<Carta> mostrarCartasPorRareza(Rareza rareza);

    List<Carta> mostrarCartasPorTipo(Tipo tipo);

    Carta cargarNuevaCarta(Carta carta);

    public void eliminarCartaPorId(Long id);

    Carta actualizarCarta(Long id, Carta carta);
}
