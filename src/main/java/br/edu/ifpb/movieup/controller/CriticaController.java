package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import br.edu.ifpb.movieup.service.CriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriticaController {

    @Autowired
    private CriticaService criticaService;


    @GetMapping("/criticas")
    public List<Critica> getCriticas() {
        return this.criticaService.getCriticas();
    }

    @GetMapping("/filmecriticado")
    public List<Critica> FilmeCriticado(@RequestBody Filme filme){ return this.criticaService.getFilmeCriticado(filme);}

   @PostMapping("/criticas")
    public Critica inserirCritica(@RequestBody Critica critica){
        return this.criticaService.inserir(critica);
    }

    @DeleteMapping("/criticas/{id}")
    public void apagarCritica(@PathVariable("id") Long id) {
        this.criticaService.apagar(id);
    }
}

