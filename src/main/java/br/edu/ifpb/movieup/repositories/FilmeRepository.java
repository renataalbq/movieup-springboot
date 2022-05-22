package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository  extends JpaRepository<Filme, Long> {
}
