package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.entidades.Tipo;
import lairentcg.lairen.excepciones.EncontradoExcepcion;
import lairentcg.lairen.excepciones.NoEncontradoExcepcion;
import lairentcg.lairen.repositorios.iCartaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaServiceImp implements iCartaService {

    @Autowired
    private iCartaRepo iCartaRepo;

    @Override
    public List<Carta> mostrarTodasLasCartas() {
        List<Carta> cartas = iCartaRepo.findAll();
        return cartas;
    }

    @Override
    public List<Carta> mostrarPorNombreOrdenado() {
        List<Carta> cartas = iCartaRepo.traerCartasOrdenarPorNombre();
        return cartas;
    }

    @Override
    public Optional<Carta> mostrarCartaPorID(Long id) {
        Optional <Carta> carta = iCartaRepo.findById(id);
        if (carta.isPresent()) {
            return carta;
        } else {
            throw new NoEncontradoExcepcion("No pudo encontrarse la carta ingresada.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Optional<Carta> mostrarCartaPorNombre(String nombre) {
        Optional <Carta> carta = iCartaRepo.findByNombreCarta(nombre);
        if (carta.isPresent()) {
            return carta;
        } else {
            throw new NoEncontradoExcepcion("No pudo encontrarse la carta ingresada.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List <Carta> mostrarPorParteDelNombre(String nombre) {
        List <Carta> carta = iCartaRepo.findByNombreCartaContaining(nombre);
        if (carta.isEmpty()) {
            throw new NoEncontradoExcepcion("No pudo encontrarse cartas con ese el nombre ingresado.", "A-002", HttpStatus.NOT_FOUND);
        } else {
            return carta;
        }
    }

    @Override
    public List<Carta> mostrarCartasPorExpansion(Expansion expansion) {
        List <Carta> cartaPorExpansion = iCartaRepo.findByExpansion(expansion);
        return cartaPorExpansion;
    }

    @Override
    public List<Carta> mostrarCartasPorCoste(Long coste) {
        List<Carta> cartasPorCoste = iCartaRepo.findByCosteCarta(coste);
        return cartasPorCoste;
    }

    @Override
    public List<Carta> mostrarCartasPorRareza(Rareza rareza) {
        List <Carta> cartaPorRareza = iCartaRepo.findByRareza(rareza);
        return cartaPorRareza;
    }

    @Override
    public List<Carta> mostrarCartasPorTipo(Tipo tipo) {
        List <Carta> cartaPorTipo = iCartaRepo.findByTipo(tipo);
        return cartaPorTipo;
    }


    @Override
    public Carta cargarNuevaCarta(Carta carta) {
        Optional <Carta> buscarCarta = iCartaRepo.findByNombreCarta(carta.getNombreCarta());
        if (buscarCarta.isPresent()) {
            throw new EncontradoExcepcion("La carta con el nombre ingresado ya se encuentra registrada.", "A-001", HttpStatus.CONFLICT);
        } else {
            return iCartaRepo.save(carta);
        }
    }

    @Override
    public void eliminarCartaPorId(Long id) {
        Optional <Carta> carta = iCartaRepo.findById(id);
        if (carta.isPresent()) {
            iCartaRepo.deleteById(id);
        } else {
            throw new NoEncontradoExcepcion("No pudo encontrarse la carta ingresada.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Carta actualizarCarta(Long id, Carta carta) {
        Optional <Carta> buscarCarta = iCartaRepo.findById(id);
        if (buscarCarta.isPresent()) {
            return iCartaRepo.save(carta);
        } else {
            throw new NoEncontradoExcepcion("No pudo encontrarse la carta ingresada.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

}
