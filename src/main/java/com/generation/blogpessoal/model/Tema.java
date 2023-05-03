package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity//entidade
@Table(name = "tb_temas")//tabela + nome
public class Tema {
	
	//chave primaria = autoIncrement
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Notnull nao pode ser vazio com comentario
	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;
	
	//um tema pra varias postagens //carregar de maneira lenta//one da relação(1 tema>N postagens)//  caso apague um tema, toda as postagens vao junto
	@OneToMany(fetch = FetchType.LAZY, mappedBy="tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("postagem")
	private List<Postagem> postagem;//todas as postagens atreladas ao respectivo tema

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
