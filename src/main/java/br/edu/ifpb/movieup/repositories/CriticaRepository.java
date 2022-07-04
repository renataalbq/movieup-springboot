package br.edu.ifpb.movieup.repositories;

import br.edu.ifpb.movieup.model.Critica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CriticaRepository extends JpaRepository<Critica, Long> {

    @Query(value = "SELECT c from Critica c where c.filme.id = ?1")
    List<Critica> findCriticasByFilme(Long id_filme);

    @Modifying
    @Query(value = "DELETE from Critica c where c.id = ?1")
    void deleteCriticaById(Long id);


    @Transactional
    @Modifying
    @Query("UPDATE Critica SET mensagem =?1, nomeDoCritico =?2 WHERE id =?3")
    void updateCritica(String mensagem, String nomeDoCritico, Long id);

}
