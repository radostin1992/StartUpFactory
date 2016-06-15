package mse.usermanagement.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mse.usermanagement.model.User;

@Stateless
public class UserService {

	private static final Integer PAGE_SIZE = 4;

	@PersistenceContext
	private EntityManager entityManager;

	public void save(User user) {
		entityManager.merge(user);
	}

	public List<User> getUsers(Integer page) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.getUsers", User.class);

		Integer startPosition = (page - 1) * PAGE_SIZE;

		query.setFirstResult(startPosition);

		query.setMaxResults(PAGE_SIZE);

		return query.getResultList();
	}

	public Integer getPageCount() {
		TypedQuery<Long> query = entityManager.createNamedQuery("User.count", Long.class);
		Long count = query.getSingleResult();
		Long pages = count / PAGE_SIZE;
		if (count == 0 || count % PAGE_SIZE > 0) {
			pages++;
		}
		return pages.intValue();
	}

	public void delete(User user) {
		Query query = entityManager.createNamedQuery("User.delete");
		query.setParameter("id", user.getId());
		query.executeUpdate();
	}

	public User getUser(Long id) {
		return entityManager.find(User.class, id);
	}

	public User getUserByUsername(String username) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.getUserByUsername", User.class);
		query.setParameter("username", username);
		List<User> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}

	}

	public User login(String username, String password) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.login", User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<User> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}
}
