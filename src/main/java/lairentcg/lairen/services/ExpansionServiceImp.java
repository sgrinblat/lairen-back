package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.repositorios.iExpansionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpansionServiceImp implements iExpansionService{

    @Autowired
    private iExpansionRepo iExpansionRepo;

    @Override
    public List<Expansion> mostrarTodasLasExpansiones() {
        List<Expansion> expansiones = iExpansionRepo.findAll();
        return expansiones;
    }

    @Override
    public Optional<Expansion> mostrarExpansionPorID(Long id) {
        Optional<Expansion> expansion = iExpansionRepo.findById(id);
        return expansion;
    }

    @Override
    public Optional<Expansion> mostrarExpansionPorNombre(String nombre) {
        Optional<Expansion> expansion = iExpansionRepo.findByNombreExpansion(nombre);
        return expansion;
    }

    @Override
    public Expansion cargarNuevaExpansion(Expansion expansion) {
        Optional <Expansion> buscarExpa = iExpansionRepo.findByNombreExpansion(expansion.getNombreExpansion());
        if (buscarExpa.isPresent()) {
            return null;
        } else {
            return iExpansionRepo.save(expansion);
        }
    }

    @Override
    public void eliminarExpansionPorId(Long id) {
        Optional <Expansion> expansion = iExpansionRepo.findById(id);
        if (expansion.isPresent()) {
            iExpansionRepo.deleteById(id);
        }
    }

    @Override
    public Expansion actualizarExpansion(Long id, Expansion expansion) {
        Optional <Expansion> buscarExpa = iExpansionRepo.findById(expansion.getIdExpansion());
        if (buscarExpa.isPresent()) {
            return iExpansionRepo.save(expansion);
        } else {
            return null;
        }
    }
}
