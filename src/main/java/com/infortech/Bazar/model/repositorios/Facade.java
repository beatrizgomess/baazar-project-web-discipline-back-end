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

	private static Facade myself = null;
	public Facade() {
		this.loteRepository = new LoteRepository();
		this.odRepository = new OrgaoDonatarioRepository();
		this.ofRepository = new OrgaoFiscalizadorRepository();
		this.produtoRepository = new ProdutoRepository();
	}


	public static Facade getCurrentInstance(){
		if(myself == null){
			myself = new Facade();
		}
		return myself;
	}
	
	
	//Métodos Facade Lote
	
	public void createLote(Lote lote) {
		this.loteRepository.create(lote);
	}
	
	public void updateLote(Lote lote) {
		this.loteRepository.update(lote);
	}
	
	public Lote readLoteById(int id) {
		return this.loteRepository.read(id);
	}
	
	public void deleteLoteById(int id) {
		this.loteRepository.delete(id);
	}
	
	public List<Lote> readAllLote(){
		return this.loteRepository.readAll();
	}
	
	//Métodos Facade OrgaoDonatario
	
	public void createOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
		this.odRepository.create(orgaoDonatario);
	}
	
	public void updateOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
		this.odRepository.update(orgaoDonatario);
	}
	
	public OrgaoDonatario readOrgaoDonatarioById(int id) {
		return this.odRepository.read(id);
	}
	
	public void deleteOrgaoDonatarioById(int id) {
		this.odRepository.delete(id);
	}
	
	public List<OrgaoDonatario> readAllOrgaoDonatario(){
		return this.odRepository.readAll();
	}




	//Métodos Facade OrgaoFiscalizador
	
	public void createOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
		this.ofRepository.create(orgaoFiscalizador);
	}
	
	public void updateOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
		this.ofRepository.update(orgaoFiscalizador);
	}
	
	public OrgaoFiscalizador readOrgaoFiscalizadorById(int id) {
		return this.ofRepository.read(id);
	}
	
	public void deleteOrgaoFiscalizadorById(int id) {
		this.ofRepository.delete(id);
	}
	
	public List<OrgaoFiscalizador> readAllOrgaoFiscalizador(){
		return this.ofRepository.readAll();
	}
	
	//Métodos Facade Produto
	
	public void createProduto(Produto produto) {
		this.produtoRepository.create(produto);
	}
	
	public void updateProduto(Produto produto) {
		this.produtoRepository.update(produto);
	}
	
	public Produto readProdutoById(int codigo) {
		return this.produtoRepository.read(codigo);
	}
	
	public void deleteProdutoById(int codigo) {
		this.produtoRepository.delete(codigo);
	}
	
	public List<Produto> readAllProduto(){
		return this.produtoRepository.readAll();
	}
	
} //End of Class Facade
