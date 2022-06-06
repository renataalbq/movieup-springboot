package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.model.Favoritos;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.service.FavoritosService;
import br.edu.ifpb.movieup.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;
    private FilmeService filmeService;

    @GetMapping("/favoritos")
    public List<Favoritos> getFavoritos() {
        return this.favoritosService.getFavoritos();
    }

    @PostMapping("/favoritos")
    public Favoritos inserirFav(@RequestBody Long idFilme){
        Optional<Filme> optionalFilme = filmeService.findById(idFilme);
        if (!optionalFilme.isPresent()){
            return null;
        }
        var favorito = new Favoritos();
        favorito.setImagem(optionalFilme.get().getImagem());
        favorito.setTitulo(optionalFilme.get().getTitulo());

        return this.favoritosService.inserir(idFilme);
    }

    @DeleteMapping("/favoritos/{id}")
    public void apagarFav(@PathVariable("id") Long id) {
        this.favoritosService.apagar(id);
    }
}
