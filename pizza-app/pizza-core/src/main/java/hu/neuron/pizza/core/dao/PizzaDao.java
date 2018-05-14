package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Pizza;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PizzaDao implements BaseDao<Pizza> {
	@PersistenceContext
	private EntityManager entityManager; // ő az az objektum akin keresztül lehet querryket futtatni és rendelkezik crud műveletekkel
	//ne legyenek entitások a service rétegen felül
	@Override
	public Long save(Pizza e) {
		entityManager.persist(e); //visszatöltődik az id az adott entitásba ezért csak simán elkérhetjük
		return e.getId();
	}

	@Override
	public Pizza find(Long id) {
		return entityManager.find(Pizza.class, id);
	}

	@Override
	public void update(Pizza e) {
		entityManager.merge(e);
		
	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public List<Pizza> findall() {
		TypedQuery<Pizza> typedQuery = entityManager.createQuery("select a from Pizza a",Pizza.class);
		return typedQuery.getResultList();
	}
	
}
