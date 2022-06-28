package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import br.edu.ifpb.movieup.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CriticaRepository criticaRepository;


    //public List<Filme> getFilmes() {
    //    return this.filmeRepository.findAll();
    //}

    public List<Filme> getFilmes() {
        List<Filme> listaFilmes = new ArrayList<>();

        List<Filme> listaFilmesRetorno = new ArrayList<>();

        listaFilmes.addAll(filmeRepository.findAll()); // adiciona todos os filmes em uma lista
        // percorre a lista de filmes
        for(Filme filme : listaFilmes){
            List<Critica> criticas = new ArrayList<>();
            criticas.addAll(criticaRepository.findCriticasByFilme(filme.getId())); //adiciona as criticas pegando pelo id do filme
            filme.setCriticas(criticas);
            listaFilmesRetorno.add(filme); // monta o filme com as criticas especificas
        }
        return listaFilmesRetorno;
    }

    public Filme getFilmeById(Long id) {
        List<Critica> criticas = new ArrayList<>();
        Filme filme = filmeRepository.findById(id).get();
        criticas.addAll(criticaRepository.findCriticasByFilme(filme.getId()));
        filme.setCriticas(criticas); // adiciona criticas em filme
        return filme;
    }

    public List<Filme> buscarEmAlta(String opcao) {
        return this.filmeRepository.buscarEmAlta(opcao);
    }

    public List<Filme> buscarFavoritos(String opcao) {
        return this.filmeRepository.buscarFavoritos(opcao);
    }

    public List<Filme> buscarAclamados(String opcao) {
        return this.filmeRepository.buscarAclamados(opcao);
    }

    public List<Filme> buscarEsperados(String opcao) {
        return this.filmeRepository.buscarEsperados(opcao);
    }

    public List<Filme> buscarFavSemana(String opcao) {
        return this.filmeRepository.buscarFavSemana(opcao);
    }

    public List<Filme> buscarFilme(String titulo) {
        return this.filmeRepository.buscarFilme(titulo);
    }


}

