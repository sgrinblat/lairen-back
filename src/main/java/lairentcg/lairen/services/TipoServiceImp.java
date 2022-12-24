package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.entidades.Tipo;
import lairentcg.lairen.repositorios.iTipoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImp implements iTipoService {

    @Autowired
    private iTipoRepo iTipoRepo;

    @Override
    public List<Tipo> mostrarTodosLosTipos() {
        List<Tipo> tipo = iTipoRepo.findAll();
        return tipo;
    }

    @Override
    public Optional<Tipo> mostrarTipoPorID(Long id) {
        Optional<Tipo> tipo = iTipoRepo.findById(id);
        return tipo;
    }

    @Override
    public Optional<Tipo> mostrarTipoPorNombre(String nombre) {
        Optional<Tipo> tipo = iTipoRepo.findByNombreTipo(nombre);
        return tipo;
    }

    @Override
    public Tipo cargarNuevaTipo(Tipo tipo) {
        Optional <Tipo> buscarTipo = iTipoRepo.findByNombreTipo(tipo.getNombreTipo());
        if (buscarTipo.isPresent()) {
            return null;
        } else {
            return iTipoRepo.save(tipo);
        }
    }

    @Override
    public void eliminarTipoPorId(Long id) {
        Optional <Tipo> rareza = iTipoRepo.findById(id);
        if (rareza.isPresent()) {
            iTipoRepo.deleteById(id);
        }
    }

    @Override
    public Tipo actualizarTipo(Long id, Tipo tipo) {
        Optional <Tipo> buscarTipo = iTipoRepo.findById(tipo.getIdTipo());
        if (buscarTipo.isPresent()) {
            return iTipoRepo.save(tipo);
        } else {
            return null;
        }
    }
}
