package com.infortech.Bazar.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.infortech.Bazar.model.classes.OrgaoDonatario;
import org.aspectj.weaver.ast.Or;

public class OrgaoDonatarioRepository implements GenericRepository<OrgaoDonatario, Integer>{
	
	public void create(OrgaoDonatario orgaoDonatario) {
        String sql = "insert into OrgaoDonatario(NOME,ENDERECO,TELEFONE,HORARIO_FUNCIONAMENTO,DESCRICAO) values(?,?,?,?,?)";

        try {

            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
            //pstm.setInt(1, (orgaoDonatario.getId()));
            pstm.setString(1, (orgaoDonatario.getNome()));
            pstm.setString(2, (orgaoDonatario.getEndereco()));
            pstm.setString(3, (orgaoDonatario.getTelefone()));
            pstm.setString(4, (orgaoDonatario.getHorarioFuncionamento()));
            pstm.setString(5, (orgaoDonatario.getDescricao()));



            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
	public void update(OrgaoDonatario orgaoDonatario) {
        String sql = "update OrgaoDonatario set NOME=?, ENDERECO=?, TELEFONE=?, HORARIO_FUNCIONAMENTO=?, DESCRICAO=? where ID=?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, orgaoDonatario.getNome());
            pstm.setString(2, orgaoDonatario.getEndereco());
            pstm.setString(3, orgaoDonatario.getTelefone());
            pstm.setString(4, orgaoDonatario.getHorarioFuncionamento());
            pstm.setString(5, orgaoDonatario.getDescricao());
            pstm.setInt(6, orgaoDonatario.getId());

            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public OrgaoDonatario read(Integer id) {
        String sql = "select * from OrgaoDonatario where id=?";

        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            if(result.next()){
                OrgaoDonatario orgaoDonatario =  new OrgaoDonatario();
                orgaoDonatario.setId(Integer.parseInt(result.getString("id")));
                orgaoDonatario.setNome(result.getString("NOME"));
                orgaoDonatario.setEndereco(result.getString("ENDERECO"));
                orgaoDonatario.setTelefone(result.getString("TELEFONE"));
                orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
                orgaoDonatario.setDescricao(result.getString("DESCRICAO"));

                return orgaoDonatario;
            }



        } catch (SQLException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    public void delete(Integer id) {
        String sql = "delete from OrgaoDonatario where ID=?";

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
    
    public List<OrgaoDonatario> readAll(){
        String sql = "select * from OrgaoDonatario";
        List<OrgaoDonatario> orgaoDonatarios = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = ConnectionManager.getCurrentConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                OrgaoDonatario orgaoDonatario =  new OrgaoDonatario();
                orgaoDonatario.setId(Integer.parseInt(result.getString("ID")));
                orgaoDonatario.setNome(result.getString("NOME"));
                orgaoDonatario.setEndereco(result.getString("ENDERECO"));
                orgaoDonatario.setTelefone(result.getString("TELEFONE"));
                orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
                orgaoDonatario.setDescricao(result.getString("DESCRICAO"));

                orgaoDonatarios.add(orgaoDonatario);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrgaoDonatarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return orgaoDonatarios;
    }
}
