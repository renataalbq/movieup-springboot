package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import br.edu.ifpb.movieup.repositories.FilmeRepository;
import br.edu.ifpb.movieup.service.CriticaService;
import br.edu.ifpb.movieup.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private CriticaService criticaService;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CriticaRepository criticaRepository;

    @GetMapping
    public List<Filme> getFilmes() {
        return this.filmeService.getFilmes();
    }

    @GetMapping("/{id}")
    public Filme getFilmeById(@PathVariable("id") Long id) {
        return this.filmeService.getFilmeById(id);
    }

    @RequestMapping(value= ("/titulo"), method = RequestMethod.GET)
    public List<Filme> buscarFilme(@RequestParam("titulo") String titulo) {
        return this.filmeService.buscarFilme(titulo);
    }

    // Adicionar critica em filme
    @PostMapping("/criticas/{id}")
    public ResponseEntity adicionarCritica(@PathVariable Long id, @RequestBody Critica critica){
        Optional<Filme> filmecriticado = filmeRepository.findById(id);
        critica.setId_filme(filmecriticado.get().getId());
        criticaRepository.save(critica);
        return ResponseEntity.status(HttpStatus.OK).body("Critica adicionada");
    }

    // Ler criticas de filme
    @GetMapping( "/{id}/criticas")
    public List<Critica> findByIdFilme(@PathVariable Long id) {
        return criticaRepository.findCriticasByFilme(id);
    }

    @DeleteMapping("/{id_filme}/criticas/{id}")
    public void apagarCritica(@PathVariable("id_filme") Long id_filme, @PathVariable("id") Long id) {
        this.criticaService.apagar(id);
    }

    @GetMapping("/emalta")
    public ResponseEntity<List<Filme>> buscarEmAlta(String opcao){
        List <Filme> filme = filmeService.buscarEmAlta(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }

    @GetMapping("/favoritos")
    public ResponseEntity<List<Filme>> buscarFavoritos(String opcao){
        List <Filme> filme = filmeService.buscarFavoritos(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }
    @GetMapping("/aclamados")
    public ResponseEntity<List<Filme>> buscarAclamados(String opcao){
        List <Filme> filme = filmeService.buscarAclamados(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }
    @GetMapping("/esperados")
    public ResponseEntity<List<Filme>> buscarEsperados(String opcao){
        List <Filme> filme = filmeService.buscarEsperados(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }

    @GetMapping("/favsemana")
    public ResponseEntity<List<Filme>> buscarFavSemana(String opcao){
        List <Filme> filme = filmeService.buscarFavSemana(opcao);
        return new ResponseEntity<List<Filme>>(filme, HttpStatus.OK);
    }
}
