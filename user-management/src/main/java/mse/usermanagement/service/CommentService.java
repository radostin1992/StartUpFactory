package mse.usermanagement.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import mse.usermanagement.model.Comment;

public class CommentService implements Serializable {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Comment> getCommentsForBlogWithId(Long id) {
		TypedQuery<Comment> query = entityManager.createNamedQuery("Comment.getComments", Comment.class);
		query.setParameter("blogId", id);
		List<Comment> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
}
