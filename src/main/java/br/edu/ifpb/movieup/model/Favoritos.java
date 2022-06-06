package br.edu.ifpb.movieup.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_favoritos")
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String imagem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_filme")
    private Filme idFilme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_serie")
    private Serie idSerie;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Filme getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Filme idFilme) {
        this.idFilme = idFilme;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }
}
