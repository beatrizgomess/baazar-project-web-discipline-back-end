package com.infortech.Bazar.model.classes;

import java.sql.Date;

public class Lote {
	private int id;
	private Date dataEntrega;
	private String observacao;
//	private OrgaoDonatario id_orgao_donatario;
//	private OrgaoFiscalizador id_orgao_fiscalizador;
	private OrgaoDonatario orgaoDonatario;
	private OrgaoFiscalizador orgaoFiscalizador;
	private int idOrgaoDonatario;
	private int idOrgaoFiscalizador;
	
	
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
	
	//New getters & setters IdOrgaoDonatario/Fiscalizador
	public int getIdOrgaoDonatario() {
		return idOrgaoDonatario;
	}
	public void setIdOrgaoDonatario(int idOrgaoDonatario) {
		this.idOrgaoDonatario = idOrgaoDonatario;
	}
	public int getIdOrgaoFiscalizador() {
		return idOrgaoFiscalizador;
	}
	public void setIdOrgaoFiscalizador(int idOrgaoFiscalizador) {
		this.idOrgaoFiscalizador = idOrgaoFiscalizador;
	}
	
	//Nome dos métodos revisados
	public OrgaoDonatario getOrgaoDonatario() {
		return orgaoDonatario;
	}
	public void setOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
		this.orgaoDonatario = orgaoDonatario;
	}
	public OrgaoFiscalizador getOrgaoFiscalizador() {
		return orgaoFiscalizador;
	}
	public void setOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
		this.orgaoFiscalizador = orgaoFiscalizador;
	}
	
	//Possivelmente revisar nome dos métodos.
//	public OrgaoDonatario getId_orgao_donatario() {
//		return id_orgao_donatario;
//	}
//
//	public void setId_orgao_donatario(OrgaoDonatario id_orgao_donatario) {
//		this.id_orgao_donatario = id_orgao_donatario;
//	}
//
//	public OrgaoFiscalizador getId_orgao_fiscalizador() {
//		return id_orgao_fiscalizador;
//	}
//
//	public void setId_orgao_fiscalizador(OrgaoFiscalizador id_orgao_fiscalizador) {
//		this.id_orgao_fiscalizador = id_orgao_fiscalizador;
//	}
}
