package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Favoritos;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.service.FavoritosService;
import br.edu.ifpb.movieup.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;
    private FilmeService filmeService;

    @GetMapping
    public List<Favoritos> getFavoritos() {
        return this.favoritosService.getFavoritos();
    }

    @PostMapping
    public Favoritos inserirFav(Favoritos favoritos){
        Filme filme = filmeService.getFilmeById(Long.valueOf(favoritos.getIdFilme()));
        favoritos.setImagem(filme.getImagem());
        favoritos.setTitulo(filme.getTitulo());
        return favoritosService.inserirFav(favoritos);
    }

    @DeleteMapping("/{id}")
    public void apagarFav(@PathVariable("id") Long id) {
        this.favoritosService.apagar(id);
    }
}
