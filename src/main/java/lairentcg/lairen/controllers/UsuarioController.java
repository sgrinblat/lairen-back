package lairentcg.lairen.controllers;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Usuario;
import lairentcg.lairen.services.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UsuarioController {

    @Autowired
    private iUsuarioService servicio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/user/{nombre}")
    public Usuario buscarUsuarioPorNombre(@PathVariable String nombre) {
        return this.servicio.buscarUsuarioPorNombre(nombre);
    }

    @PostMapping("/user/crear")
    public Usuario nuevoUsuario(@RequestBody Usuario usuario) {
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        return servicio.guardarUsuario(usuario);
    }
}
