package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
}
