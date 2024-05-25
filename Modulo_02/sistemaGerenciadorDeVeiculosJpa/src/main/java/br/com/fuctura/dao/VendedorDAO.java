package br.com.fuctura.dao;


import java.util.List;

import br.com.fuctura.entidade.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class VendedorDAO {

	public void adicionarAlterar(Vendedor v, EntityManager em) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}
	
	public List<Vendedor> consultarTodos(EntityManager em) {
		String jpql = "SELECT v FROM Vendedor v";
		TypedQuery<Vendedor> consulta = em.createQuery(jpql, Vendedor.class);
		return consulta.getResultList();
	}
	
	
	public List<Vendedor> consultar(String nomeCpf, EntityManager em) {
		String jpql = "SELECT v FROM Vendedor v WHERE UPPER(nome) LIKE UPPER(:nomeCpf) OR cpf LIKE :nomeCpf";
		TypedQuery<Vendedor> consulta = em.createQuery(jpql, Vendedor.class);
		consulta.setParameter("nomeCpf", "%"+nomeCpf+"%");
		
		return consulta.getResultList();
	}
	
	public Vendedor consultarCPF(String cpf, EntityManager em) {
		String jpql = "SELECT v FROM Vendedor v WHERE cpf = :cpf";
		TypedQuery<Vendedor> consulta = em.createQuery(jpql, Vendedor.class);
		consulta.setParameter("cpf", cpf);
		Vendedor result = new Vendedor();
		try {
			return consulta.getSingleResult();
		} catch (NoResultException e) {
			return result;
		}
	}
	
	public void remover(Vendedor v, EntityManager em) {
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();
	}
}
