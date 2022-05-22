package br.edu.ifpb.movieup.repositories;


import br.edu.ifpb.movieup.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
