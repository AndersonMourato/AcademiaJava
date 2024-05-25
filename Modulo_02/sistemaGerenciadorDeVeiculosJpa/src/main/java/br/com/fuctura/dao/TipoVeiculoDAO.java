package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entidade.TipoVeiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TipoVeiculoDAO {
	
	public List<TipoVeiculo> consultaTodos(EntityManager em) {
		String jpql = "SELECT t FROM TipoVeiculo t";
		TypedQuery<TipoVeiculo> consulta = em.createQuery(jpql, TipoVeiculo.class);
		return consulta.getResultList();
	}
}
