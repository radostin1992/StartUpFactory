package mse.usermanagement.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mse.usermanagement.model.Comment;

@Stateless
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

	public void save(Comment comment) {
		entityManager.merge(comment);
	}

	public void delete(Comment comment) {
		Query query = entityManager.createNamedQuery("Comment.delete");
		query.setParameter("id", comment.getId());
		query.executeUpdate();
	}
}
