package com.infortech.Bazar.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.infortech.Bazar.model.classes.Lote;
import com.infortech.Bazar.model.classes.OrgaoDonatario;
import com.infortech.Bazar.model.classes.OrgaoFiscalizador;
import com.infortech.Bazar.model.classes.Produto;

public class LoteRepository implements GenericRepository<Lote, Integer>{
	
	public void create(Lote lt) {
		String sql 	= "INSERT INTO Lote(ID_ORGAO_FISCALIZADOR, ID_ORGAO_DONATARIO, DATA_ENTREGA, OBSERVACAO) VALUES (?, ?, ?, ?)";
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
		String sql = "update Lote set DATA_ENTREGA=?, OBSERVACAO=? where ID=?";

		try{
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			pstm.setDate(1, lt.getDataEntrega());
			pstm.setString(2, lt.getObservacao());
			pstm.setInt(3, lt.getId());
			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    
    public Lote read(Integer id) {
		String sql = "SELECT * FROM Lote as l join OrgaoDonatario as od join OrgaoFiscalizador as ofl on (l.ID_ORGAO_DONATARIO = od.ID and l.ID_ORGAO_FISCALIZADOR = ofl.ID) where l.id =?;";

		Lote lote = null;
		try {
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

			pstm.setInt(1, id);

			ResultSet result = pstm.executeQuery();

			if (result.next()) {

				lote = new Lote();

				lote.setId(result.getInt("ID"));
				lote.setDataEntrega(result.getDate("DATA_ENTREGA"));
				lote.setObservacao(result.getString("OBSERVACAO"));


				OrgaoDonatario orgaoDonatario = new OrgaoDonatario();
				orgaoDonatario.setId(result.getInt("ID"));
				orgaoDonatario.setNome(result.getString("NOME"));
				orgaoDonatario.setEndereco(result.getString("ENDERECO"));
				orgaoDonatario.setTelefone(result.getString("TELEFONE"));
				orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
				orgaoDonatario.setDescricao(result.getString("DESCRICAO"));


				OrgaoFiscalizador orgaoFiscalizador = new OrgaoFiscalizador();
				orgaoFiscalizador.setId(result.getInt("ID"));
				orgaoFiscalizador.setNome(result.getString("NOME"));
				orgaoFiscalizador.setDescricao(result.getString("DESCRICAO"));

				lote.setId_orgao_fiscalizador(orgaoFiscalizador);
				lote.setId_orgao_donatario(orgaoDonatario);
			}

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lote;
    }
    
    
    public void delete(Integer id) {
		String sql = "delete from Lote where id=?";

		try{
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

			pstm.setInt(1, id);
			pstm.execute();

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
    
    public List<Lote> readAll(){
		String sql = "SELECT Lote.ID, OrgaoFiscalizador.NOME, OrgaoDonatario.NOME, Lote.DATA_ENTREGA, Lote.OBSERVACAO\n" +
				"FROM ((Lote INNER JOIN  OrgaoFiscalizador ON Lote.ID_ORGAO_FISCALIZADOR = OrgaoFiscalizador.ID)\n" +
				"INNER JOIN OrgaoDonatario ON Lote.ID_ORGAO_DONATARIO = OrgaoDonatario.ID);";

		List<Lote> lotes = null;


		try {
			PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			lotes = new ArrayList<Lote>();

			while (result.next()) {

				Lote lote = new Lote();
				lote.setId(result.getInt("ID"));
				lote.setDataEntrega(result.getDate("DATA_ENTREGA"));
				lote.setObservacao(result.getString("OBSERVACAO"));

				OrgaoFiscalizador orgaoFiscalizador = new OrgaoFiscalizador();
				orgaoFiscalizador.setId(result.getInt("ID"));
				orgaoFiscalizador.setNome(result.getString("NOME"));



				OrgaoDonatario orgaoDonatario = new OrgaoDonatario();
				orgaoDonatario.setId(result.getInt("ID"));
				/*
				orgaoDonatario.setNome(result.getString("NOME"));
				orgaoDonatario.setEndereco(result.getString("ENDERECO"));
				orgaoDonatario.setTelefone(result.getString("TELEFONE"));
				orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
				orgaoDonatario.setDescricao(result.getString("DESCRICAO"));

				 */

				lote.setId_orgao_donatario(orgaoDonatario);
				lote.setId_orgao_fiscalizador(orgaoFiscalizador);

				lotes.add(lote);
			}


		} catch (SQLException ex) {
			Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lotes;
    }
    
}
