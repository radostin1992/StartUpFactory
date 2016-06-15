package mse.usermanagement.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mse.usermanagement.model.Blog;

@Stateless
public class BlogService {

	private static final Integer PAGE_SIZE = 4;

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Blog blog) {
		entityManager.merge(blog);
	}

	public List<Blog> getBlogs(Integer page) {
		TypedQuery<Blog> query = entityManager.createNamedQuery("Blog.getBlogs", Blog.class);

		Integer startPosition = (page - 1) * PAGE_SIZE;

		query.setFirstResult(startPosition);

		query.setMaxResults(PAGE_SIZE);

		return query.getResultList();
	}

	public void delete(Blog blog) {
		Query query = entityManager.createNamedQuery("Blog.delete");
		query.setParameter("id", blog.getId());
		query.executeUpdate();
	}

	public Blog getBlog(Long id) {
		return entityManager.find(Blog.class, id);
	}

	public Integer getPageCount() {
		TypedQuery<Long> query = entityManager.createNamedQuery("Blog.count", Long.class);
		Long count = query.getSingleResult();
		Long pages = count / PAGE_SIZE;
		if (count == 0 || count % PAGE_SIZE > 0) {
			pages++;
		}
		return pages.intValue();
	}

	public Blog getBlogByTitle(String username) {
		TypedQuery<Blog> query = entityManager.createNamedQuery("Blog.getBlogByTitle", Blog.class);
		query.setParameter("title", username);
		List<Blog> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}

	}

}
