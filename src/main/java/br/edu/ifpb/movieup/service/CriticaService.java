package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Critica;
import br.edu.ifpb.movieup.repositories.CriticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public Critica inserirOuAtualizar(Critica critica) {
        Critica criticaInserida = this.criticaRepository.save(critica);
        return criticaInserida;
    }

    public void apagar(Long id) {
        this.criticaRepository.deleteById(id);
    }
}

