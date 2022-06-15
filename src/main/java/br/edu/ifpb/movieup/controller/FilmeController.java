package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import br.edu.ifpb.movieup.repositories.FilmeRepository;
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
    private FilmeRepository filmeRepository;

    @Autowired
    private CriticaRepository criticaRepository;

    @GetMapping
    public List<Filme> getFilmes() {
        return this.filmeService.getFilmes();
    }


    @GetMapping("/detalhes")
    public List<Filme> getDetalhes() {
        return this.filmeService.getDetalhes();
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
    @PostMapping("/addcritica/{id}")
    public ResponseEntity adicionarCritica(@PathVariable Long id, @RequestBody Critica critica){
        return filmeRepository.findById(id).map(f -> {
            critica.setFilmeCriticado(f);
            f.adicionarCritica(critica);
            criticaRepository.save(critica);
            filmeRepository.save(f);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // Ler criticas de filme
    @GetMapping( "/{id}/criticas")
    public List<Critica> findById1(@PathVariable Long id) {
        return filmeRepository.findById(id).get().getCriticas();
    }

    @GetMapping("/{id}/criticas/{idCritica}")
    public List<Critica> findById2(@PathVariable Long id, @PathVariable Long idCritica) {
        List<Critica> critica = filmeRepository.findById(id).get().getCriticas();
        List<Critica> criticaRetornada = new ArrayList<>();
        critica.forEach(c -> {
            if (c.getId() == idCritica) {
                criticaRetornada.add(c);
            }
        });
        return criticaRetornada;
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
