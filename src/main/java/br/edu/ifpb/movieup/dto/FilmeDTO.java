package br.edu.ifpb.movieup.dto;

import br.edu.ifpb.movieup.model.Critica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmeDTO {
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
    private List<Critica> criticas;

}
