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

public class ProdutoRepository implements GenericRepository<Produto, Integer>{
	
	public void create(Produto produto) {
        String sql = "insert into Produto(CODIGO,ID_LOTE,NOME,DESCRICAO) values(?,?,?,?)";

        try {

            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, (produto.getCodigo()));
            pstm.setInt(2, (produto.getId_lote().getId()));
            pstm.setString(3, (produto.getNome()));
            pstm.setString(4, (produto.getDescricao()));

            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
	public void update(Produto produto) {
        String sql = "update Produto set NOME=?, DESCRICAO=? where CODIGO=?";

        try{
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        pstm.setString(1, produto.getNome());
        pstm.setString(2, produto.getDescricao());
        pstm.setInt(3, produto.getCodigo());
        pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Produto read(Integer codigo) {
    	String sql = "select p.CODIGO, p.NOME, p.DESCRICAO as PROD_DESC, p.ID_LOTE,\r\n"
    			+ "lt.ID as LT_ID, lt.DATA_ENTREGA, lt.OBSERVACAO,\r\n"
    			+ "od.ID as OD_ID, od.NOME as OD_NOME, od.ENDERECO, od.TELEFONE, od.HORARIO_FUNCIONAMENTO, od.DESCRICAO as OD_DESC,\r\n"
    			+ "ofl.ID as OF_ID, ofl.NOME as OF_NOME, ofl.DESCRICAO as OF_DESC\r\n"
    			+ "from Produto as p join Lote as lt join OrgaoFiscalizador as ofl join OrgaoDonatario as od\r\n"
    			+ "on (p.id_lote = lt.id) where p.codigo = ? group by p.CODIGO;";
    	
        Produto produto = null;
        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, codigo);

            ResultSet result = pstm.executeQuery();

            if (result.next()) {

                produto = new Produto();

                produto.setCodigo(result.getInt("CODIGO"));
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("PROD_DESC"));


                Lote lote = new Lote();

                lote.setId(result.getInt("LT_ID"));
                lote.setDataEntrega(result.getDate("DATA_ENTREGA"));
                lote.setObservacao(result.getString("OBSERVACAO"));

                OrgaoFiscalizador orgaoFiscalizador = new OrgaoFiscalizador();
                orgaoFiscalizador.setId(result.getInt("OF_ID"));
                orgaoFiscalizador.setNome(result.getString("OF_NOME"));
                orgaoFiscalizador.setDescricao(result.getString("OF_DESC"));

                OrgaoDonatario orgaoDonatario = new OrgaoDonatario();
                orgaoDonatario.setId(result.getInt("OD_ID"));
                orgaoDonatario.setDescricao(result.getString("OD_DESC"));
                orgaoDonatario.setEndereco(result.getString("ENDERECO"));
                orgaoDonatario.setHorarioFuncionamento(result.getString("HORARIO_FUNCIONAMENTO"));
                orgaoDonatario.setNome(result.getString("OD_NOME"));
                orgaoDonatario.setTelefone(result.getString("TELEFONE"));
                
                lote.setId_orgao_fiscalizador(orgaoFiscalizador);
                lote.setId_orgao_donatario(orgaoDonatario);

                produto.setId_lote(lote);


            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
    
    
    public void delete(Integer codigo) {
        String sql = "delete from Produto where codigo=?";

        try{
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, codigo);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<Produto> readAll() {
        String sql = "select * from Produto as p join Lote as lt on (p.id_lote = lt.id)";

        List<Produto> produtos = null;
        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            produtos = new ArrayList<Produto>();

            while (result.next()) {

                Produto produto = new Produto();

                produto.setCodigo(result.getInt("CODIGO"));
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("DESCRICAO"));


                Lote lote = new Lote();
                lote.setId(result.getInt("ID"));
                lote.setDataEntrega(result.getDate("DATA_ENTREGA"));
                lote.setObservacao(result.getString("OBSERVACAO"));

                produto.setId_lote(lote);
                produtos.add(produto);
            }


        } catch (SQLException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

}
