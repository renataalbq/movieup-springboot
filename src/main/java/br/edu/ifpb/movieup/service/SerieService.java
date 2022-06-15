package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.model.Serie;
import br.edu.ifpb.movieup.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> buscarSerie(String titulo) {
        return this.serieRepository.buscarSerie(titulo);
    }

    public List<Serie> getSeries() {
        return this. serieRepository.findAll();
    }

    public List<Serie> buscarEmAlta(String opcao) {
        return this.serieRepository.buscarEmAlta(opcao);
    }

    public List<Serie> buscarVencedoras(String opcao) {
        return this.serieRepository.buscarVencedoras(opcao);
    }
    public List<Serie> buscarLancamentos(String opcao) {
        return this.serieRepository.buscarLancamentos(opcao);
    }


}

