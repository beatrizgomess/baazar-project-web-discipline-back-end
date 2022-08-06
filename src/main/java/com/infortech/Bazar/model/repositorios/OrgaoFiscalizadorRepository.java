package com.infortech.Bazar.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.infortech.Bazar.model.classes.OrgaoDonatario;
import com.infortech.Bazar.model.classes.OrgaoFiscalizador;

public class OrgaoFiscalizadorRepository implements GenericRepository<OrgaoFiscalizador, Integer> {
	
	public void create(OrgaoFiscalizador orgaoFiscalizador) {
        String sql = "insert into OrgaoFiscalizador(NOME, DESCRICAO) values(?,?)";

        try {

            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
            //pstm.setInt(1, (orgaoFiscalizador.getId()));
            pstm.setString(1, (orgaoFiscalizador.getNome()));
            pstm.setString(2, orgaoFiscalizador.getDescricao());

            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
	public void update(OrgaoFiscalizador orgaoFiscalizador) {
        String sql = "update OrgaoFiscalizador set NOME=?, DESCRICAO=? where ID=?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, orgaoFiscalizador.getNome());
            pstm.setString(2, orgaoFiscalizador.getDescricao());

            pstm.setInt(3, orgaoFiscalizador.getId());

            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public OrgaoFiscalizador read(Integer id) {
        String sql = "select * from OrgaoFiscalizador where id=?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            if(result.next()){
                OrgaoFiscalizador orgaoFiscalizador =  new OrgaoFiscalizador();
                orgaoFiscalizador.setId(Integer.parseInt(result.getString("ID")));
                orgaoFiscalizador.setNome(result.getString("NOME"));
                orgaoFiscalizador.setDescricao(result.getString("DESCRICAO"));

                return orgaoFiscalizador;
            }



        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    public void delete(Integer id) {
        String sql = "delete from OrgaoFiscalizador where ID=?";

        try{
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, String.valueOf(id));
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<OrgaoFiscalizador> readAll(){
        String sql = "select * from OrgaoFiscalizador";
        List<OrgaoFiscalizador> orgaoFiscalizadors = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = ConnectionManager.getCurrentConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                OrgaoFiscalizador orgaoFiscalizador =  new OrgaoFiscalizador();
                orgaoFiscalizador.setId(Integer.parseInt(result.getString("ID")));
                orgaoFiscalizador.setNome(result.getString("NOME"));
                orgaoFiscalizador.setDescricao(result.getString("DESCRICAO"));

                orgaoFiscalizadors.add(orgaoFiscalizador);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orgaoFiscalizadors;
    }
}


