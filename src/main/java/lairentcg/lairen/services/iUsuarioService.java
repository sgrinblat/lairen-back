package lairentcg.lairen.services;

import lairentcg.lairen.entidades.Tipo;
import lairentcg.lairen.entidades.Usuario;

import java.util.Optional;

public interface iUsuarioService {

    Usuario buscarUsuarioPorNombre(String nombre);

    Usuario guardarUsuario(Usuario usuario);

}
