package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
