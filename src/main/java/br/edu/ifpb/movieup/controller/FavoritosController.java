package br.edu.ifpb.movieup.controller;

import br.edu.ifpb.movieup.dto.FilmeDTO;
import br.edu.ifpb.movieup.model.Favoritos;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.service.FavoritosService;
import br.edu.ifpb.movieup.service.FilmeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;
    private FilmeService filmeService;

    public FavoritosController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }


    @GetMapping
    public List<Favoritos> getFavoritos() {
        return this.favoritosService.getFavoritos();
    }

    @PostMapping
    public Favoritos inserirFav(FilmeDTO filmeDTO, Filme filmeManipulado){
        Favoritos favoritos = new Favoritos();
        BeanUtils.copyProperties(filmeDTO, filmeManipulado);
        filmeManipulado = this.filmeService.getFilmeById(filmeManipulado.getId());
        favoritos.setImagem(filmeManipulado.getImagem());
        favoritos.setTitulo(filmeManipulado.getTitulo());
        favoritos.setIdFilme(filmeManipulado);
        return favoritosService.inserir(favoritos);
    }

    @DeleteMapping("/{id}")
    public void apagarFav(@PathVariable("id") Long id) {
        this.favoritosService.apagar(id);
    }
}
