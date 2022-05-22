package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> getFilmes() {
        return this.filmeRepository.findAll();
    }

    public Filme getFilmePorId(Long idFilme) {
        return this.filmeRepository.findById(idFilme).orElse(null);
    }

}

