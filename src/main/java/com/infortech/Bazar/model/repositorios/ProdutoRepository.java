package com.infortech.Bazar.model.repositorios;

import java.util.List;

import com.infortech.Bazar.model.classes.Produto;

public class ProdutoRepository implements GenericRepository<Produto, Integer>{
	
	public void create(Produto p) {
		
	}
    
	public void update(Produto p) {
    	
    }
    
    public Produto read(Integer codigo) {
    	return null;
    }
    
    
    public void delete(Integer codigo) {
    	
    }
    
    public List<Produto> readAll(){
    	return null;
    }
}
