package lairentcg.lairen.controllers;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.services.iRarezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rareza")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class RarezaController {

    @Autowired
    private iRarezaService servicio;

    @GetMapping("/rarezas")
    public List<Rareza> todasLasRarezas() {
        return this.servicio.mostrarTodasLasRarezas();
    }

    @GetMapping("/rarezas/{id}")
    public Optional<Rareza> rarezaPorID(@PathVariable Long id) {
        return this.servicio.mostrarRarezaPorID(id);
    }

    @GetMapping("/rarezas/nombre/{nombre}")
    public Optional<Rareza> rarezaPorNombre(@PathVariable String nombre) {
        return this.servicio.mostrarRarezaPorNombre(nombre);
    }

    @PostMapping("/rarezas/crear")
    public Rareza nuevaRareza(@RequestBody Rareza rareza) {
        return servicio.cargarNuevaRareza(rareza);
    }

    @DeleteMapping("/rarezas/eliminar/{id}")
    public void eliminarRarezaPorID(@PathVariable Long id) {
        servicio.eliminarRarezaPorId(id);
    }

    @PutMapping("/rarezas/actualizar/{id}")
    public void actualizarRareza(@PathVariable Long id, @RequestBody Rareza rareza) {
        servicio.actualizarRareza(id, rareza);
    }

}
