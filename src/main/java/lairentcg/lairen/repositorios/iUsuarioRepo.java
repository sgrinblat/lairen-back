package lairentcg.lairen.repositorios;

import lairentcg.lairen.entidades.Expansion;
import lairentcg.lairen.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iUsuarioRepo extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
