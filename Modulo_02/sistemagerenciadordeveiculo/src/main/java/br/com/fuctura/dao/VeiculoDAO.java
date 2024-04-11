package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Veiculo;

public class VeiculoDAO {
	
	public void insert(Connection conn, Veiculo v) throws SQLException {
		String sql = "insert into veiculo (placa, modelo, ano, valor) values (?, ?, ?, ?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, v.getPlaca());
		pstm.setString(2, v.getModelo());
		pstm.setInt(3, v.getAno());
		pstm.setFloat(4, v.getValor());
		pstm.execute();
	}

	public void update(Connection conn, Veiculo v) throws SQLException {
		String sql = "update veiculo set placa = ?, modelo = ?, ano = ?, valor = ? where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, v.getPlaca());
		pstm.setString(2, v.getModelo());
		pstm.setInt(3, v.getAno());
		pstm.setFloat(4, v.getValor());
		pstm.setInt(5, v.getCodigo());
		pstm.execute();
	}
	
	public void delete(Connection conn, Veiculo v) throws SQLException {
		String sql = "delete from veiculo where codigo = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, v.getCodigo());
		pstm.execute();
	}
	
	public List<Veiculo> getModeloPlaca(Connection conn, String search) throws SQLException {
		String sql = "select * from veiculo where modelo like ? or placa like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, search);
		pstm.setString(2, search);
	    ResultSet rs = pstm.executeQuery();
		
	    List<Veiculo> list = new ArrayList<>();
	    while (rs.next()) {
	    	Veiculo v = new Veiculo();
	    	v.setCodigo(rs.getInt("codigo"));
	    	v.setPlaca(rs.getString("placa"));
			v.setModelo(rs.getString("modelo"));
			v.setAno(rs.getInt("ano"));
			v.setValor(rs.getInt("valor"));
	        list.add(v);
	    }
	    return list;
	}

	public Veiculo getPlaca(Connection conn, String placa) throws SQLException {
		String sql = "select * from veiculo where placa like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, placa);
	    ResultSet rs = pstm.executeQuery();
	    while (rs.next()) {
	    	Veiculo v = new Veiculo();
	    	v.setCodigo(rs.getInt("codigo"));
	    	v.setPlaca(rs.getString("placa"));
			v.setModelo(rs.getString("modelo"));
			v.setAno(rs.getInt("ano"));
			v.setValor(rs.getInt("valor"));
			return v;
	    }
	    return null;
	}
	
	public List<Veiculo> getAll(Connection conn) throws SQLException {
		String sql = "select * from veiculo";
		PreparedStatement pstm = conn.prepareStatement(sql);
	    ResultSet rs = pstm.executeQuery();
	    
		List<Veiculo> list = new ArrayList<>();
	    while (rs.next()) {
	    	Veiculo v = new Veiculo();
	    	v.setCodigo(rs.getInt("codigo"));
	    	v.setPlaca(rs.getString("placa"));
			v.setModelo(rs.getString("modelo"));
			v.setAno(rs.getInt("ano"));
			v.setValor(rs.getFloat("valor"));
	        list.add(v);
	    }
	    return list;
	}
}
