package br.edu.ifpb.movieup.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String imagem;
    private Integer dataLancamento;
    private String sinopse;
    private String genero;
    private String diretor;
    private String atores;
    private Integer temporadas;

    private String emalta;
    private String vencedoras;
    private String lancamentos;

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

    public Integer getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Integer dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public String getEmalta() { return emalta;}
    public void setEmalta(String emalta) { this.emalta = emalta; }

    public String getVencedoras() { return vencedoras;}
    public void setVencedoras(String vencedoras) { this.vencedoras = vencedoras; }

    public String getLancamentos() { return lancamentos;}
    public void setALancamentos(String lancamentos) { this.lancamentos = lancamentos; }
}
