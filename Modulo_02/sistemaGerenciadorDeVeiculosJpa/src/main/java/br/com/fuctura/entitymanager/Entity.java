package br.com.fuctura.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Entity {
	private static EntityManager em;
	
	public static EntityManager getManager() {
		if(em == null) {
			var emf = Persistence.createEntityManagerFactory("FUCTURA-PU");
			Entity.em = emf.createEntityManager();			
			return em;
		}
		return em;
	}
	
}
