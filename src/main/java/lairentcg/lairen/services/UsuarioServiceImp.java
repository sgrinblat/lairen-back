package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Carta;
import lairentcg.lairen.entidades.Usuario;
import lairentcg.lairen.excepciones.EncontradoExcepcion;
import lairentcg.lairen.excepciones.NoEncontradoExcepcion;
import lairentcg.lairen.repositorios.iUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImp implements iUsuarioService {


    @Autowired
    private iUsuarioRepo iUsuarioRepo;

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        Usuario usuario = iUsuarioRepo.findByUsername(nombre);
        if (usuario.getUsername() != null) {
            return usuario;
        } else {
            throw new NoEncontradoExcepcion("No pudo encontrarse al usuario ingresado.", "A-002", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        Usuario usuarioNuevo = iUsuarioRepo.findByUsername(usuario.getUsername());
        if (usuarioNuevo != null) {
            throw new EncontradoExcepcion("El usuario con el nombre ingresado ya se encuentro registrado.", "A-001", HttpStatus.CONFLICT);
        } else {
            return iUsuarioRepo.save(usuario);
        }
    }


}
