package lairentcg.lairen.controllers;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Rareza;
import lairentcg.lairen.entidades.Tipo;
import lairentcg.lairen.services.iCartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carta")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CartaController {

    @Autowired
    private final iCartaService servicio;

    public CartaController(iCartaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/cartas")
    public List<Carta> todasLasCartas() {
        return this.servicio.mostrarTodasLasCartas();
    }

    @GetMapping("/cartas/ordenadas")
    public List<Carta> todasLasCartasOrdenadas() {
        return this.servicio.mostrarPorNombreOrdenado();
    }

    @GetMapping("/cartas/{id}")
    public Optional<Carta> cartaPorID(@PathVariable Long id) {
        return this.servicio.mostrarCartaPorID(id);
    }

    @GetMapping("/cartas/nombrecompleto/{nombre}")
    public Optional<Carta> cartaPorNombre(@PathVariable String nombre) {
        return this.servicio.mostrarCartaPorNombre(nombre);
    }

    @GetMapping("/cartas/nombre/{nombre}")
    public List <Carta> cartaPorParteDelNombre(@PathVariable String nombre) {
        return this.servicio.mostrarPorParteDelNombre(nombre);
    }

    @GetMapping("/cartas/expansion/{expansion}")
    public List <Carta> cartasPorExpansion(@PathVariable Expansion expansion) {
        return this.servicio.mostrarCartasPorExpansion(expansion);
    }

    @GetMapping("/cartas/rareza/{rareza}")
    public List <Carta> cartasPorRareza(@PathVariable Rareza rareza) {
        return this.servicio.mostrarCartasPorRareza(rareza);
    }

    @GetMapping("/cartas/tipo/{tipo}")
    public List <Carta> cartasPorTipo(@PathVariable Tipo tipo) {
        return this.servicio.mostrarCartasPorTipo(tipo);
    }

    @GetMapping("/cartas/coste/{coste}")
    public List <Carta> cartasPorTipo(@PathVariable Long coste) {
        return this.servicio.mostrarCartasPorCoste(coste);
    }

    @PostMapping("/cartas/crear")
    public Carta nuevaCarta(@RequestBody Carta carta) {
        return servicio.cargarNuevaCarta(carta);
    }

    @DeleteMapping("/cartas/eliminar/{id}")
    public void eliminarCartaPorID(@PathVariable Long id) {
        servicio.eliminarCartaPorId(id);
    }

    @PutMapping("/cartas/actualizar/{id}")
    public void actualizarCarta(@PathVariable Long id, @RequestBody Carta carta) {
        servicio.actualizarCarta(id, carta);
    }

}
