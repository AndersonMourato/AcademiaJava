package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Vendedor;

public class VendedorDAO {
	public void insert(Connection conn, Vendedor v) throws SQLException {
		String sql = "insert into vendedor (nome) values (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, v.getNome());
		pstm.execute();
	}

	public void update(Connection conn, Vendedor v) throws SQLException {
		String sql = "update vendedor set nome = ?, where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, v.getNome());
		pstm.setInt(2, v.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, Vendedor v) throws SQLException {
		String sql = "delete from vendedor where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, v.getCodigo());
		pstm.execute();
	}
		
	public List<Vendedor> getAll(Connection conn) throws SQLException {
		String sql = "select * from vendedor";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<Vendedor> list = new ArrayList<>();
	    while (rs.next()) {
	    	Vendedor v = new Vendedor();
	    	v.setCodigo(rs.getInt("codigo"));
	    	v.setNome(rs.getString("nome"));
	        list.add(v);
	    }
	    return list;
	}
}