package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Loja;

public class LojaDAO {
	public void insert(Connection conn, Loja l) throws SQLException {
		String sql = "insert into loja (nome) values (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, l.getNome());
		pstm.execute();
	}

	public void update(Connection conn, Loja l) throws SQLException {
		String sql = "update loja set nome = ?, where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, l.getNome());
		pstm.setInt(2, l.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, Loja l) throws SQLException {
		String sql = "delete from loja where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, l.getCodigo());
		pstm.execute();
	}
		
	public List<Loja> getAll(Connection conn) throws SQLException {
		String sql = "select * from loja";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<Loja> list = new ArrayList<>();
	    while (rs.next()) {
	    	Loja l = new Loja();
	    	l.setCodigo(rs.getInt("codigo"));
	    	l.setNome(rs.getString("nome"));
	        list.add(l);
	    }
	    return list;
	}
}