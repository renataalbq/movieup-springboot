package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;


    public List<Filme> getFilmes() {
        return this.filmeRepository.findAll();
    }

    public List<Filme> getDetalhes() {
        return this.filmeRepository.findAll();
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


    public Filme getFilmeById(Long id) {
        return this.filmeRepository.findById(id).get();
    }

    public Optional<Filme> findById(Long id){
        return filmeRepository.findById(id);
    }
}

