package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.User;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserDao implements BaseDao<User> {
	@PersistenceContext
	private EntityManager entityManager; // ő az az objektum akin keresztül lehet querryket futtatni és rendelkezik crud műveletekkel
	//ne legyenek entitások a service rétegen felül
	@Override
	public Long save(User e) {
		entityManager.persist(e); //visszatöltődik az id az adott entitásba ezért csak simán elkérhetjük
		return e.getId();
	}

	@Override
	public User find(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void update(User e) {
		entityManager.merge(e);
		
	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public List<User> findall() {
		TypedQuery<User> typedQuery = entityManager.createQuery("select a from User a",User.class);
		return typedQuery.getResultList();
	}
	
}
