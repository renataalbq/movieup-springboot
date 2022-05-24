package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    @GetMapping("/filmes")
    public List<Filme> getFilmes() {
        return this.filmeService.getFilmes();
    }

    @GetMapping("/filmes/{id}")
    public Filme getFilmePorId(@PathVariable("id") Long idFilme) {
        return this.filmeService.getFilmePorId(idFilme);
    }
}
