package lairentcg.lairen.controllers;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.services.iExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expansion")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ExpansionController {

    @Autowired
    private iExpansionService servicio;

    @GetMapping("/expansiones")
    public List<Expansion> todasLasExpansiones() {
        return this.servicio.mostrarTodasLasExpansiones();
    }

    @GetMapping("/expansiones/{id}")
    public Optional<Expansion> buscarExpaPorId(@PathVariable Long id) {
        return this.servicio.mostrarExpansionPorID(id);
    }

    @GetMapping("/expansiones/nombre/{nombre}")
    public Optional<Expansion> buscarExpaPorNombre(@PathVariable String nombre) {
        return this.servicio.mostrarExpansionPorNombre(nombre);
    }

    @PostMapping("/expansiones/crear")
    public Expansion nuevaExpansion(@RequestBody Expansion expansion) {
        return servicio.cargarNuevaExpansion(expansion);
    }

    @DeleteMapping("/expansiones/eliminar/{id}")
    public void eliminarExpansionPorID(@PathVariable Long id) {
        servicio.eliminarExpansionPorId(id);
    }

    @PutMapping("/expansiones/actualizar/{id}")
    public void actualizarExpansion(@PathVariable Long id, @RequestBody Expansion expansion) {
        servicio.actualizarExpansion(id, expansion);
    }
}
