package com.infortech.Bazar.model.repositorios;

import java.util.List;

import com.infortech.Bazar.model.classes.Lote;
import com.infortech.Bazar.model.classes.OrgaoDonatario;
import com.infortech.Bazar.model.classes.OrgaoFiscalizador;
import com.infortech.Bazar.model.classes.Produto;

public class Facade {
	private LoteRepository loteRepository = null;
	private OrgaoDonatarioRepository odRepository = null;
	private OrgaoFiscalizadorRepository ofRepository = null;
	private ProdutoRepository produtoRepository = null;
	
	
	public Facade() {
		this.loteRepository = new LoteRepository();
		this.odRepository = new OrgaoDonatarioRepository();
		this.ofRepository = new OrgaoFiscalizadorRepository();
		this.produtoRepository = new ProdutoRepository();
	}
	
	
	//Métodos Facade Lote
	
	public void createLote(Lote lote) {
		this.loteRepository.create(lote);
	}
	
	public void updateLote(Lote lote, int id) {
		
	}
	
	public Lote readLoteById(int id) {
		return null;
	}
	
	public void deleteLoteById(int id) {
		
	}
	
	public List<Lote> readAllLote(){
		return null;
	}
	
	//Métodos Facade OrgaoDonatario
	
	public void createOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
		
	}
	
	public void updateOrgaoDonatario(OrgaoDonatario orgaoDonatario, int id) {
		
	}
	
	public OrgaoDonatario readOrgaoDonatarioById(int id) {
		return null;
	}
	
	public void deleteOrgaoDonatarioById(int id) {
		
	}
	
	public List<OrgaoDonatario> readAllOrgaoDonatario(){
		return null;
	}
	
	//Métodos Facade OrgaoFiscalizador
	
	public void createOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
		
	}
	
	public void updateOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador, int id) {
		
	}
	
	public OrgaoFiscalizador readOrgaoFiscalizadorById(int id) {
		return null;
	}
	
	public void deleteOrgaoFiscalizadorById(int id) {
		
	}
	
	public List<OrgaoFiscalizador> readAllOrgaoFiscalizador(){
		return null;
	}
	
	//Métodos Facade Produto
	
	public void createProduto(Produto produto) {
		
	}
	
	public void updateProduto(Produto produto, int id) {
		
	}
	
	public Produto readProdutoById(int codigo) {
		return null;
	}
	
	public void deleteProdutoById(int codigo) {
		
	}
	
	public List<Produto> readAllProduto(){
		return null;
	}
	
} //End of Class Facade
