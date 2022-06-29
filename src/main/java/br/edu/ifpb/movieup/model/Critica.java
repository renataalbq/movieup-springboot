package br.edu.ifpb.movieup.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_critica")
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String mensagem;
    private String nomeDoCritico;

    private Long id_filme;

    private Long id_serie;

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeDoCritico() {
        return nomeDoCritico;
    }

    public void setNomeDoCritico(String nomeDoCritico) {
        this.nomeDoCritico = nomeDoCritico;
    }

    public Long getId_filme() {
        return id_filme;
    }

    public void setId_filme(Long id_filme) {
        this.id_filme = id_filme;
    }

    public Long getId_serie() {
        return id_serie;
    }

    public void setId_serie(Long id_serie) {
        this.id_serie = id_serie;
    }
}
