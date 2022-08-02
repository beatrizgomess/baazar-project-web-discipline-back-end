package com.infortech.Bazar.model.classes;

import java.sql.Date;

public class Lote {
	private int id;
	private Date dataEntrega;
	private String observacao;
	private OrgaoDonatario id_orgao_donatario;
	private OrgaoFiscalizador id_orgao_fiscalizador;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public OrgaoDonatario getId_orgao_donatario() {
		return id_orgao_donatario;
	}

	public void setId_orgao_donatario(OrgaoDonatario id_orgao_donatario) {
		this.id_orgao_donatario = id_orgao_donatario;
	}

	public OrgaoFiscalizador getId_orgao_fiscalizador() {
		return id_orgao_fiscalizador;
	}

	public void setId_orgao_fiscalizador(OrgaoFiscalizador id_orgao_fiscalizador) {
		this.id_orgao_fiscalizador = id_orgao_fiscalizador;
	}
}
