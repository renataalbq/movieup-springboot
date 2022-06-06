package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Favoritos;
import br.edu.ifpb.movieup.repositories.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    public List<Favoritos> getFavoritos() { return this.favoritosRepository.findAll();}

    @Transactional
    public Favoritos inserirFav(Favoritos favoritos) {
        return favoritosRepository.save(favoritos);
    }

    public void apagar(Long id) {
        this.favoritosRepository.deleteById(id);
    }

}
