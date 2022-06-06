package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/filmes")
    public List<Filme> getFilmes() {
        return this.filmeService.getFilmes();
    }

    @GetMapping("/detalhes")
    public List<Filme> getDetalhes() {
        return this.filmeService.getDetalhes();
    }

    @GetMapping("/filmes/id")
    public  Optional<Filme> getById(Long id) {
        return this.filmeService.findById(id);
    }

    @GetMapping("/filmes/emalta")
    public ResponseEntity<List<Filme>> buscarEmAlta(String opcao){
        List <Filme> filme = filmeService.buscarEmAlta(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }

    @GetMapping("/filmes/favoritos")
    public ResponseEntity<List<Filme>> buscarFavoritos(String opcao){
        List <Filme> filme = filmeService.buscarFavoritos(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }
    @GetMapping("/filmes/aclamados")
    public ResponseEntity<List<Filme>> buscarAclamados(String opcao){
        List <Filme> filme = filmeService.buscarAclamados(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }
    @GetMapping("/filmes/esperados")
    public ResponseEntity<List<Filme>> buscarEsperados(String opcao){
        List <Filme> filme = filmeService.buscarEsperados(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }

    @GetMapping("/filmes/favsemana")
    public ResponseEntity<List<Filme>> buscarFavSemana(String opcao){
        List <Filme> filme = filmeService.buscarFavSemana(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }
}
