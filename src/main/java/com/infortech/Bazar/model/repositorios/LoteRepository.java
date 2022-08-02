package com.infortech.Bazar.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.infortech.Bazar.model.classes.Lote;

public class LoteRepository implements GenericRepository<Lote, Integer>{
	
	public void create(Lote lt) {
		String sql 	= "INSERT INTO LOTE (ID_ORGAO_FISCALIZADOR, ID_ORGAO_DONATARIO, DATA_ENTREGA, OBSERVACAO) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			ps.setInt(1, lt.getId_orgao_fiscalizador().getId());
			ps.setInt(2, lt.getId_orgao_donatario().getId());
			ps.setString(3, String.valueOf(lt.getDataEntrega()));
			ps.setString(4, lt.getObservacao());
			
			ps.execute();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("An error ocurred while creating a lote");
		}
	}
    
	public void update(Lote lt) {
    	
    }
    
    public Lote read(Integer id) {
    	return null;
    }
    
    
    public void delete(Integer id) {
    	
    }
    
    public List<Lote> readAll(){
    	return null;
    }
    
}
