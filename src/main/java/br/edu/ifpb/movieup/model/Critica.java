package br.edu.ifpb.movieup.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "tb_critica")
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String mensagem;
    private String nomeDoCritico;

    @ManyToOne
    @JsonBackReference
    private Filme filme;

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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

    public void setId(Long id) {
        this.id = id;
    }
}
