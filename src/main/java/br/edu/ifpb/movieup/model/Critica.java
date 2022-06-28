package br.edu.ifpb.movieup.model;

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
    @JoinColumn(name = "fk_filme_id")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "fk_serie_id")
    private Serie serie;

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

    public Filme getFilmeCriticado() {
        return filme;
    }

    public void setFilmeCriticado(Filme filme) {
        this.filme = filme;
    }
}
