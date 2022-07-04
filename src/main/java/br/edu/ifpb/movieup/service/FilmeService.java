package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import br.edu.ifpb.movieup.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CriticaRepository criticaRepository;


    public List<Filme> getFilmes() {
        return this.filmeRepository.findAll();
    }

    @Transactional
    public void acrescentarCritica(Critica critica, Long idFilme){
        Optional<Filme> filmeCriticado = filmeRepository.findById(idFilme);
        if(filmeCriticado.isPresent()){
            filmeCriticado.get().adicionarCritica(critica);
            critica.setFilme(filmeCriticado.get());
        }
    }
    @Transactional
    public void apagarCritica(Long id){
        this.criticaRepository.deleteCriticaById(id);
    }

    @Transactional
    public void atualizarCritica(String mensagem, String nomeDoCritico, Long id){

        this.criticaRepository.updateCritica(mensagem, nomeDoCritico, id);

    }


    public Filme getFilmeById(Long id) {
        return this.filmeRepository.findById(id).orElse(null);
    }

    //;

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

