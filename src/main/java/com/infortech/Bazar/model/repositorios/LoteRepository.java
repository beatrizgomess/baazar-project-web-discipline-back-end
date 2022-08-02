package com.infortech.Bazar.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.infortech.Bazar.model.classes.Lote;

public class LoteRepository implements GenericRepository<Lote, Integer>{
	
	public void create(Lote lt) {
		try {
			PreparedStatement ps = ConnectionManager.getCurrentConnection().
					prepareStatement("INSERT INTO LOTE (ID_ORGAO_FISCALIZADOR, ID_ORGAO_DONATARIO, DATA_ENTREGA, OBSERVACAO)"
							+ "VALUES (?, ?, ?, ?)");
			ps.setString(1, "1");
			ps.setString(2, "1");
			ps.setDate(3, lt.getDataEntrega());
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
