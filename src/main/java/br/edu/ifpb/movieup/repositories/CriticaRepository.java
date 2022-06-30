package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriticaRepository extends JpaRepository<Critica, Long> {

    @Query(value = "SELECT c from Critica c where c.filme.id = ?1")
    List<Critica> findCriticasByFilme(Long id);
}
