package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Favoritos;
import br.edu.ifpb.movieup.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository  extends JpaRepository<Filme, Long> {
    @Query(value = "SELECT f from Filme f where f.emalta='1' ")
    List<Filme> buscarEmAlta(String opcao);

    @Query(value = "SELECT f from Filme f where f.favoritos='1' ")
    List<Filme> buscarFavoritos(String opcao);

    @Query(value = "SELECT f from Filme f where f.aclamados='1' ")
    List<Filme> buscarAclamados(String opcao);

    @Query(value = "SELECT f from Filme f where f.esperados='1' ")
    List<Filme> buscarEsperados(String opcao);
    @Query(value = "SELECT f from Filme f where f.favsemana='1' ")
    List<Filme> buscarFavSemana(String opcao);

    }
