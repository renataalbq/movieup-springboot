package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Serie;
import br.edu.ifpb.movieup.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> getSeries() {
        return this. serieRepository.findAll();
    }

    public Serie getSeriePorId(Long idSerie) {
        return this. serieRepository.findById(idSerie).orElse(null);
    }

}

