package com.infortech.Bazar.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.infortech.Bazar.model.classes.Lote;
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
        String sql = "select * from Produto as p join Lote as lt on (p.id_lote = lt.id) where p.codigo = ?";

        Produto produto = null;
        try {
            PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

            pstm.setInt(1, codigo);

            ResultSet result = pstm.executeQuery();

            if (result.next()) {

                produto = new Produto();

                produto.setCodigo(Integer.parseInt(result.getString("CODIGO")));
                //produto.setId_lote(result.getString("ID_LOTE"));
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("DESCRICAO"));


                Lote lote = new Lote();

                lote.setId(result.getInt("ID"));
                lote.setDataEntrega(result.getDate("DATA_ENTREGA"));
                lote.setObservacao(result.getString("OBSERVAÇÃO"));
                //lote.setId_orgao_fiscalizador(result.getInt("ID_ORGAO_FISCALIZADOR"));
                //lote.setId_orgao_donatario(result.getInt("ID_ORGAO_DONATARIO"));

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
                //produto.setNomeDono(result.getString("nomedono"));


                Lote lote = new Lote();

                lote.setId(result.getInt("ID"));
                lote.setDataEntrega(result.getDate("DATA_ENTREGA"));
                lote.setObservacao(result.getString("OBSERVACAO"));
                //lote.setId_orgao_fiscalizador(result.getObject("ID_ORGAO_FISCALIZADOR"));
                //lote.setId_orgao_donatario(result.getDouble("ID_ORGAO_DONATARIO"));

                produto.setId_lote(lote);
            }


        } catch (SQLException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

}
