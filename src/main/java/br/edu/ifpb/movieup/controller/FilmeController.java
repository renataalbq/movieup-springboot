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
    private CriticaRepository criticaRepository;

    @GetMapping
    public List<Filme> getFilmes() {
        return this.filmeService.getFilmes();
    }

    @GetMapping("/{id}")
    public Filme getFilmeById(@PathVariable("id") Long id) {
        return this.filmeService.getFilmeById(id);
    }

    @GetMapping("/titulo")
    public List<Filme> buscarFilme(@RequestParam("titulo") String titulo) {
        return this.filmeService.buscarFilme(titulo);
    }

    // Ler criticas de filme
    @GetMapping( "/{id_filme}/criticas")
    public List<Critica> findByIdFilme(@PathVariable Long id_filme) {
        return criticaRepository.findCriticasByFilme(id_filme);
    }

    // Adicionar critica em filme
    @PostMapping("/criticas/{id_filme}")
    public ResponseEntity adicionarCritica(@PathVariable Long id_filme, @RequestBody Critica critica){

        filmeService.acrescentarCritica(critica, id_filme);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // atualizar critica
    @PutMapping("/criticas/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Critica critica){

        Optional<Critica> criticaOptional = this.criticaRepository.findById(id);
        if (!criticaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        this.filmeService.atualizarCritica(critica.getMensagem(), critica.getNomeDoCritico(), id);
        return ResponseEntity.ok().body(null);

    }

    // deletar critica
    @DeleteMapping("/criticas/{id}")
    public  ResponseEntity deleteCritica(@PathVariable("id") Long id) {

        Optional<Critica> criticaOptional = this.criticaRepository.findById(id);
        if (!criticaOptional.isPresent()) {
            return ResponseEntity.notFound().build();

        }
        this.filmeService.apagarCritica(id);
        return ResponseEntity.ok(null);
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
