package br.edu.ifpb.movieup.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_filme")
public class Filme {
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
    private Integer duracao;
    private String emalta;
    private String favoritos;
    private String aclamados;
    private String esperados;
    private String favsemana;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "filme")
    private List<Critica> criticas = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Integer dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getEmalta() { return emalta;}
    public void setEmalta(String emalta) { this.emalta = emalta; }

    public String getFavoritos() { return favoritos;}
    public void setFavoritos(String favoritos) { this.favoritos = favoritos; }

    public String getAclamados() { return aclamados;}
    public void setAclamados(String aclamados) { this.aclamados = aclamados; }

    public String getEsperados() { return esperados;}
    public void setEsperados(String esperados) { this.esperados = esperados; }
    public String getFavsemana() { return favsemana;}
    public void setFavsemana(String favsemana) { this.favsemana = favsemana; }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }

    public void adicionarCritica(Critica critica) {
        criticas.add(critica);
    }


}
