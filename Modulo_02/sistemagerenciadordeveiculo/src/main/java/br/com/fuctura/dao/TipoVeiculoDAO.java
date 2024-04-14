package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.TipoVeiculo;

public class TipoVeiculoDAO {
	public void insert(Connection conn, TipoVeiculo t) throws SQLException {
		String sql = "insert into tipo_veiculo (nome) values (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, t.getNome());
		pstm.execute();
	}

	public void update(Connection conn, TipoVeiculo t) throws SQLException {
		String sql = "update tipo_veiculo set nome = ?, where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, t.getNome());
		pstm.setInt(2, t.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, TipoVeiculo t) throws SQLException {
		String sql = "delete from tipo_veiculo where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, t.getCodigo());
		pstm.execute();
	}
		
	public List<TipoVeiculo> getAll(Connection conn) throws SQLException {
		String sql = "select * from tipo_veiculo";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<TipoVeiculo> list = new ArrayList<>();
	    while (rs.next()) {
	    	TipoVeiculo t = new TipoVeiculo();
	    	t.setCodigo(rs.getInt("codigo"));
	    	t.setNome(rs.getString("nome"));
	        list.add(t);
	    }
	    return list;
	}
}