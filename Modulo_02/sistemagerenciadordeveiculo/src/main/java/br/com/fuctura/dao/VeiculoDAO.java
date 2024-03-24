package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
