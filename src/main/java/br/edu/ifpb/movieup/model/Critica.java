package br.edu.ifpb.movieup.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_critica")
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mensagem;
    private String nomeDaObra;
    private String nomeDoCritico;

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeDaObra() {
        return nomeDaObra;
    }

    public void setNomeDaObra(String nomeDaObra) {
        this.nomeDaObra = nomeDaObra;
    }

    public String getNomeDoCritico() {
        return nomeDoCritico;
    }

    public void setNomeDoCritico(String nomeDoCritico) {
        this.nomeDoCritico = nomeDoCritico;
    }
}
