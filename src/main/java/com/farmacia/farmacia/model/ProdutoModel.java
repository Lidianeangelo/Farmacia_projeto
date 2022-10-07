package com.farmacia.farmacia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produto")
public class ProdutoModel {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Insira o nome do produto")
	private String nome_produto;
	
	@NotNull(message="Insira a quantidade do produto")
	private int quantidade;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Preço é obrigatório!")
    @Positive(message = "O preço deve ser maior do que zero!")
    private BigDecimal preco;
	
	@NotBlank(message="Insira a descrição do produto")
	@Size(min=1)
	private String descricao;
	
	@UpdateTimestamp
	private LocalDate data;
	
	@NotBlank(message="Insira a categoria do produto")
	@Size(min=1)
	private String categoria_prod;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria_prod() {
		return categoria_prod;
	}

	public void setCategoria_prod(String categoria_prod) {
		this.categoria_prod = categoria_prod;
	}
	
	
	
}
