package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Venda;

public class VendaDAO {
	public void insert(Connection conn, Venda v) throws SQLException {
		String sql = "insert into venda (valor) values (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDouble(1, v.getValor());
		pstm.execute();
	}

	public void update(Connection conn, Venda v) throws SQLException {
		String sql = "update venda set valor = ?, where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setDouble(1, v.getValor());
		pstm.setInt(2, v.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, Venda v) throws SQLException {
		String sql = "delete from venda where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, v.getCodigo());
		pstm.execute();
	}
		
	public List<Venda> getAll(Connection conn) throws SQLException {
		String sql = "select * from venda";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<Venda> list = new ArrayList<>();
	    while (rs.next()) {
	    	Venda v = new Venda();
	    	v.setCodigo(rs.getInt("codigo"));
	    	v.setValor(rs.getDouble("nome"));
	        list.add(v);
	    }
	    return list;
	}
}