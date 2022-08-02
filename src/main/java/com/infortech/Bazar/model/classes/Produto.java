package com.infortech.Bazar.model.classes;

public class Produto {
	private int codigo;
	private String nome;
	private String descricao;

	private Lote id_lote;


	public Lote getId_lote() {
		return id_lote;
	}

	public void setId_lote(Lote id_lote) {
		this.id_lote = id_lote;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
