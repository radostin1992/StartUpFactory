package mse.usermanagement.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mse.usermanagement.model.Blog;
import mse.usermanagement.model.Comment;
import mse.usermanagement.service.BlogService;
import mse.usermanagement.service.CommentService;

@Named
@ViewScoped
public class BlogDetailsController implements Serializable {
	private Blog blog;

	@Inject
	private BlogService blogService;

	@Inject
	private CommentService commentService;

	private Long id;

	private List<Comment> comments;

	public void onPageLoad() {
		if (id != null) {
			blog = blogService.getBlog(id);
			loadComments();

		} else {
			blog = new Blog();
		}
	}

	public void loadComments() {
		comments = commentService.getCommentsForBlogWithId(id);
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
