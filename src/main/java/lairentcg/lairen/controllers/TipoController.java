package lairentcg.lairen.controllers;

import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.entidades.Tipo;
import lairentcg.lairen.services.iTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TipoController {

    @Autowired
    private iTipoService servicio;

    @GetMapping("/tipos")
    public List<Tipo> todasLasTipo() {
        return this.servicio.mostrarTodosLosTipos();
    }

    @GetMapping("/tipos/{id}")
    public Optional<Tipo> tipoPorID(@PathVariable Long id) {
        return this.servicio.mostrarTipoPorID(id);
    }

    @GetMapping("/tipos/nombre/{nombre}")
    public Optional<Tipo> tipoPorNombre(@PathVariable String nombre) {
        return this.servicio.mostrarTipoPorNombre(nombre);
    }

    @PostMapping("/tipos/crear")
    public Tipo nuevaTipo(@RequestBody Tipo tipo) {
        return servicio.cargarNuevaTipo(tipo);
    }

    @DeleteMapping("/tipos/eliminar/{id}")
    public void eliminarTipoPorID(@PathVariable Long id) {
        servicio.eliminarTipoPorId(id);
    }

    @PutMapping("/tipos/actualizar/{id}")
    public void actualizarTipo(@PathVariable Long id, @RequestBody Tipo tipo) {
        servicio.actualizarTipo(id, tipo);
    }
}
