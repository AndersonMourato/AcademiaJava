package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Cliente;

public class ClienteDAO {
	public void insert(Connection conn, Cliente c) throws SQLException {
		String sql = "insert into cliente (nome, cpf, celular) values (?, ?, ?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, c.getNome());
		pstm.setString(2, c.getCpf());
		pstm.setString(3, c.getCelular());
		pstm.execute();
	}

	public void update(Connection conn, Cliente c) throws SQLException {
		String sql = "update cliente set nome = ?, cpf = ?, celular = ?, where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, c.getNome());
		pstm.setString(2, c.getCpf());
		pstm.setString(3, c.getCelular());
		pstm.setInt(4, c.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, Cliente c) throws SQLException {
		String sql = "delete from cliente where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, c.getCodigo());
		pstm.execute();
	}
	
	public List<Cliente> getNomeCpfTel(Connection conn, String search) throws SQLException {
		String sql = "select * from cliente where nome like ? or telefone like ?  or cpf like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, search);
		pstm.setString(2, search);
		pstm.setString(2, search);
	    ResultSet rs = pstm.executeQuery();
		
	    List<Cliente> list = new ArrayList<>();
	    while (rs.next()) {
	    	Cliente c = new Cliente();
	    	c.setCodigo(rs.getInt("codigo"));
	    	c.setNome(rs.getString("nome"));
	    	c.setCpf(rs.getString("cpf"));
			c.setCelular(rs.getString("celular"));
	        list.add(c);
	    }
	    return list;
	}

	public Cliente getCpf(Connection conn, String cpf) throws SQLException {
		String sql = "select * from cliente where cpf like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, cpf);
	    ResultSet rs = pstm.executeQuery();
	    while (rs.next()) {
	    	Cliente c = new Cliente();
	    	c.setCodigo(rs.getInt("codigo"));
	    	c.setNome(rs.getString("nome"));
	    	c.setCpf(rs.getString("cpf"));
			c.setCelular(rs.getString("celular"));
			return c;
	    }
	    return null;
	}
	
	public List<Cliente> getAll(Connection conn) throws SQLException {
		String sql = "select * from veiculo";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<Cliente> list = new ArrayList<>();
	    while (rs.next()) {
	    	Cliente c = new Cliente();
	    	c.setCodigo(rs.getInt("codigo"));
	    	c.setNome(rs.getString("nome"));
	    	c.setCpf(rs.getString("cpf"));
			c.setCelular(rs.getString("celular"));
	        list.add(c);
	    }
	    return list;
	}
}
