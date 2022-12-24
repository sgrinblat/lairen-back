package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.repositorios.iRarezaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RarezaServiceImp implements iRarezaService{

    @Autowired
    private iRarezaRepo iRarezaRepo;

    @Override
    public List<Rareza> mostrarTodasLasRarezas() {
        List<Rareza> rarezas = iRarezaRepo.findAll();
        return rarezas;
    }

    @Override
    public Optional<Rareza> mostrarRarezaPorID(Long id) {
        Optional<Rareza> rareza = iRarezaRepo.findById(id);
        return rareza;
    }

    @Override
    public Optional<Rareza> mostrarRarezaPorNombre(String nombre) {
        Optional<Rareza> rareza = iRarezaRepo.findByNombreRareza(nombre);
        return rareza;
    }

    @Override
    public Rareza cargarNuevaRareza(Rareza rareza) {
        Optional <Rareza> buscarRareza = iRarezaRepo.findByNombreRareza(rareza.getNombreRareza());
        if (buscarRareza.isPresent()) {
            return null;
        } else {
            return iRarezaRepo.save(rareza);
        }
    }

    @Override
    public void eliminarRarezaPorId(Long id) {
        Optional <Rareza> rareza = iRarezaRepo.findById(id);
        if (rareza.isPresent()) {
            iRarezaRepo.deleteById(id);
        }
    }

    @Override
    public Rareza actualizarRareza(Long id, Rareza rareza) {
        Optional <Rareza> buscarRareza = iRarezaRepo.findById(rareza.getIdRareza());
        if (buscarRareza.isPresent()) {
            return iRarezaRepo.save(rareza);
        } else {
            return null;
        }
    }
}
