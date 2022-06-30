package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.model.Filme;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CriticaService {

    @Autowired
    private CriticaRepository criticaRepository;

    public List<Critica> getCriticas() {
        return this.criticaRepository.findAll();
    }


    public Critica getCriticaPorId(Long idCritica) {
        return this.criticaRepository.findById(idCritica).orElse(null);
    }

    public List<Critica> findCriticasByFilme(Long id){return this.criticaRepository.findCriticasByFilme(id);}
    @Transactional
    public Critica inserir(Critica critica) {
        Critica criticaInserida = this.criticaRepository.save(critica);
        return criticaInserida;

    }

    public void apagar(Long id) {
        if(id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        this.criticaRepository.deleteById(id);
    }
}

