package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.model.Serie;
import br.edu.ifpb.movieup.service.FilmeService;
import br.edu.ifpb.movieup.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;


    @GetMapping
    public List<Serie> getSeries() {
        return this.serieService.getSeries();
    }

    @GetMapping("/emalta")
    public ResponseEntity<List<Serie>> buscarEmAlta(String opcao){
        List <Serie> serie = serieService.buscarEmAlta(opcao);
        return new ResponseEntity<List<Serie>>(serie, HttpStatus.OK);
    }

    @GetMapping("/vencedoras")
    public ResponseEntity<List<Serie>> buscarVencedoras(String opcao){
        List <Serie> serie = serieService.buscarVencedoras(opcao);
        return new ResponseEntity<List<Serie>>(serie, HttpStatus.OK);
    }
    @GetMapping("/lancamentos")
    public ResponseEntity<List<Serie>> buscarLancamentos(String opcao){
        List <Serie> serie = serieService.buscarLancamentos(opcao);
        return new ResponseEntity<List<Serie>>(serie, HttpStatus.OK);
    }

    @RequestMapping(value= ("/titulo"), method = RequestMethod.GET)
    public List<Serie> buscarSerie(@RequestParam("titulo") String titulo) {
        return this.serieService.buscarSerie(titulo);
    }

}
