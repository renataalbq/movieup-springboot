package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CriticaService {

    @Autowired
    private CriticaRepository criticaRepository;

    public List<Critica> getCriticas() {
        return this.criticaRepository.findAll();
    }

    public Optional<Critica> findById(Long id) {
        return criticaRepository.findById(id);
    }

    public List<Critica> findCriticasByFilme(Long id){return this.criticaRepository.findCriticasByFilme(id);}

}
