package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Endereco;

public class EnderecoDAO {
	public void insert(Connection conn, Endereco e) throws SQLException {
		String sql = "insert into endereco (cep, logradouro, complemento, numero) values (?, ?, ?, ?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, e.getCep());
		pstm.setString(2, e.getLogradouro());
		pstm.setString(3, e.getComplemento());
		pstm.setInt(4, e.getNumero());
		pstm.execute();
	}

	public void update(Connection conn, Endereco e) throws SQLException {
		String sql = "update endereco set cep = ?, logradouro = ?, complemento = ?, numero = ?, where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, e.getCep());
		pstm.setString(2, e.getLogradouro());
		pstm.setString(3, e.getComplemento());
		pstm.setInt(4, e.getNumero());
		pstm.setInt(5, e.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, Endereco e) throws SQLException {
		String sql = "delete from endereco where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, e.getCodigo());
		pstm.execute();
	}
	
	public List<Endereco> getLogradouro(Connection conn, String search) throws SQLException {
		String sql = "select * from endereco where cep like ? or logradouro like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, search);
		pstm.setString(2, search);
	    ResultSet rs = pstm.executeQuery();
		
	    List<Endereco> list = new ArrayList<>();
	    while (rs.next()) {
	    	Endereco e = new Endereco();
	    	e.setCodigo(rs.getInt("codigo"));
	    	e.setCep(rs.getString("cep"));
	    	e.setLogradouro(rs.getString("logradouro"));
			e.setComplemento(rs.getString("complemento"));
			e.setNumero(rs.getInt("numero"));
	        list.add(e);
	    }
	    return list;
	}
	
	public List<Endereco> getAll(Connection conn) throws SQLException {
		String sql = "select * from endereco";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<Endereco> list = new ArrayList<>();
	    while (rs.next()) {
	    	Endereco e = new Endereco();
	    	e.setCodigo(rs.getInt("codigo"));
	    	e.setCep(rs.getString("cep"));
	    	e.setLogradouro(rs.getString("logradouro"));
			e.setComplemento(rs.getString("complemento"));
			e.setNumero(rs.getInt("numero"));
	        list.add(e);
	    }
	    return list;
	}
}

