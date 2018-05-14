package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Topping;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ToppingDao implements BaseDao<Topping> {
	@PersistenceContext
	private EntityManager entityManager; // ő az az objektum akin keresztül lehet querryket futtatni és rendelkezik crud műveletekkel
	//ne legyenek entitások a service rétegen felül
	@Override
	public Long save(Topping e) {
		entityManager.persist(e); //visszatöltődik az id az adott entitásba ezért csak simán elkérhetjük
		return e.getId();
	}

	@Override
	public Topping find(Long id) {
		return entityManager.find(Topping.class, id);
	}

	@Override
	public void update(Topping e) {
		entityManager.merge(e);
		
	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public List<Topping> findall() {
		TypedQuery<Topping> typedQuery = entityManager.createQuery("select a from Topping a",Topping.class);
		return typedQuery.getResultList();
	}
	
}
