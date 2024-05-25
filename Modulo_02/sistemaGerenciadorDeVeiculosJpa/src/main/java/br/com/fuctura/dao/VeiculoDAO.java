package br.com.fuctura.dao;


import java.util.List;

import br.com.fuctura.entidade.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VeiculoDAO {
	public void adicionarAlterar(Veiculo v, EntityManager em) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}
	
	public List<Veiculo> consultarTodos(EntityManager em) {
		String jpql = "SELECT v FROM Veiculo v";
		TypedQuery<Veiculo> consulta = em.createQuery(jpql, Veiculo.class);
		return consulta.getResultList();
	}
	
	public List<Veiculo> consultar(String modeloPlaca, EntityManager em) {
		String jpql = "SELECT v FROM Veiculo v WHERE UPPER(modelo) LIKE UPPER(:modeloPlaca) OR UPPER(placa) LIKE UPPER(:modeloPlaca)";
		TypedQuery<Veiculo> consulta = em.createQuery(jpql, Veiculo.class);
		consulta.setParameter("modeloPlaca", "%"+modeloPlaca+"%");
		
		return consulta.getResultList();
	}	
	
	public void remover(Veiculo v, EntityManager em) {
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();
	}
}
