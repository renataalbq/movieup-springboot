package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    @Query(value = "SELECT s from Serie s where s.emalta='1' ")
    List<Serie> buscarEmAlta(String opcao);

    @Query(value = "SELECT s from Serie s where s.vencedoras='1' ")
    List<Serie> buscarVencedoras(String opcao);

    @Query(value = "SELECT s from Serie s where s.lancamentos='1' ")
    List<Serie> buscarLancamentos(String opcao);

}
