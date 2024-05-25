package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entidade.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;



public class ClienteDAO {
	public void adicionarAlterar(Cliente cl, EntityManager em) {
		em.getTransaction().begin();
		em.persist(cl);
		em.getTransaction().commit();
	}
	
	public List<Cliente> consultarTodos(EntityManager em) {
		String jpql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> consulta = em.createQuery(jpql, Cliente.class);
		return consulta.getResultList();
	}
	
	
	public List<Cliente> consultar(String nomeCpf, EntityManager em) {
		String jpql = "SELECT c FROM Cliente c WHERE UPPER(nome) LIKE UPPER(:nomeCpf) OR cpf LIKE :nomeCpf";
		TypedQuery<Cliente> consulta = em.createQuery(jpql, Cliente.class);
		consulta.setParameter("nomeCpf", "%"+nomeCpf+"%");
		
		return consulta.getResultList();
	}
	
	public void remover(Cliente cl, EntityManager em) {
		em.getTransaction().begin();
		em.remove(cl);
		em.getTransaction().commit();
	}
}
