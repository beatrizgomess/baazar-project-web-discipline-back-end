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
//			ps.setInt(1, lt.getOrgaoFiscalizador().getId());
//			ps.setInt(2, lt.getOrgaoDonatario().getId());
			ps.setInt(1, lt.getIdOrgaoFiscalizador());
			ps.setInt(2, lt.getIdOrgaoDonatario());
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
		String sql = "SELECT l.ID,  l.DATA_ENTREGA, l.OBSERVACAO, ofl.ID as ID_FISCALIZADOR, ofl.NOME as NOME_FISCALIZADOR, ofl.DESCRICAO as DESCRICAO_FISCALIZADOR,\r\n"
    			+ "od.ID as ID_DONATARIO, od.NOME as NOME_DONATARIO, od.ENDERECO, od.TELEFONE, od.HORARIO_FUNCIONAMENTO, od.DESCRICAO as DESCRICAO_DONATARIO FROM Lote as l join OrgaoDonatario as od join OrgaoFiscalizador as\r\n"
    			+ " ofl on (l.ID_ORGAO_DONATARIO = od.ID and l.ID_ORGAO_FISCALIZADOR = ofl.ID) where l.id = ?;";
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
				orgaoDonatario.setId(result.getInt("ID_DONATARIO"));
				orgaoDonatario.setNome(result.getString("NOME_DONATARIO"));
				orgaoDonatario.setEndereco(result.getString("ENDERECO"));
				orgaoDonatario.setTelefone(result.getString("TELEFONE"));
				orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
				orgaoDonatario.setDescricao(result.getString("DESCRICAO_DONATARIO"));


				OrgaoFiscalizador orgaoFiscalizador = new OrgaoFiscalizador();
				orgaoFiscalizador.setId(result.getInt("ID_FISCALIZADOR"));
				orgaoFiscalizador.setNome(result.getString("NOME_FISCALIZADOR"));
				orgaoFiscalizador.setDescricao(result.getString("DESCRICAO_FISCALIZADOR"));

				lote.setOrgaoFiscalizador(orgaoFiscalizador);
				lote.setOrgaoDonatario(orgaoDonatario);
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
		String sql = "SELECT Lote.ID, OrgaoFiscalizador.NOME as NOME_FISCALIZADOR, OrgaoFiscalizador.DESCRICAO as DESCRICAO_FISCALIZADOR,"
				+ "OrgaoDonatario.ENDERECO, OrgaoDonatario.TELEFONE, OrgaoDonatario.HORARIO_FUNCIONAMENTO, OrgaoDonatario.DESCRICAO as DESCRICAO_DONATARIO,"
				+ "OrgaoDonatario.NOME as NOME_DONATARIO, Lote.DATA_ENTREGA, Lote.OBSERVACAO\n" +
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
				orgaoFiscalizador.setNome(result.getString("NOME_FISCALIZADOR"));
				orgaoFiscalizador.setDescricao(result.getString("DESCRICAO_FISCALIZADOR"));



				OrgaoDonatario orgaoDonatario = new OrgaoDonatario();
				orgaoDonatario.setId(result.getInt("ID"));
				
				orgaoDonatario.setNome(result.getString("NOME_DONATARIO"));
				
				orgaoDonatario.setEndereco(result.getString("ENDERECO"));
				orgaoDonatario.setTelefone(result.getString("TELEFONE"));
				orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
				orgaoDonatario.setDescricao(result.getString("DESCRICAO_DONATARIO"));
				
				
				lote.setOrgaoDonatario(orgaoDonatario);
				lote.setOrgaoFiscalizador(orgaoFiscalizador);

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
