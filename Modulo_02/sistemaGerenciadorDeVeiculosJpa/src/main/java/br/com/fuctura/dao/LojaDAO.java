package br.com.fuctura.dao;

import java.util.List;

import br.com.fuctura.entidade.Loja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LojaDAO {

	public void adicionarAlterar(Loja lj, EntityManager em) {
		em.getTransaction().begin();
		em.persist(lj);
		em.getTransaction().commit();
	}
	
	public List<Loja> consultarTodos(EntityManager em) {
		String jpql = "SELECT l FROM Loja l";
		TypedQuery<Loja> consulta = em.createQuery(jpql, Loja.class);
		return consulta.getResultList();
	}
	
	public List<Loja> consultar(String nomeLoja, EntityManager em) {
		String jpql = "SELECT l FROM Loja l WHERE UPPER(nome) LIKE UPPER(:nomeTelefone) OR telefone LIKE :nomeTelefone";
		TypedQuery<Loja> consulta = em.createQuery(jpql, Loja.class);
		consulta.setParameter("nomeTelefone", "%"+nomeLoja+"%");
		
		return consulta.getResultList();
	}
	
	public void remover(Loja loja, EntityManager em) {
		em.getTransaction().begin();
		em.remove(loja);
		em.getTransaction().commit();
	}
}
