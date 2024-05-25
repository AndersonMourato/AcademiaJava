package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entidade.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VendaDAO {

	public void adicionarAlterar(Venda v, EntityManager em) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

	public List<Venda> consultar(EntityManager em) {
		String jpql = "SELECT v FROM Venda v";
		TypedQuery<Venda> consulta = em.createQuery(jpql, Venda.class);
		return consulta.getResultList();
	}
	
	public void remover(Venda venda, EntityManager em) {
		em.getTransaction().begin();
		em.remove(venda);
		em.getTransaction().commit();
	}
}
