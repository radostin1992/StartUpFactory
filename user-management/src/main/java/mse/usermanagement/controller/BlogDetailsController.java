package mse.usermanagement.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mse.usermanagement.model.Blog;
import mse.usermanagement.model.Comment;
import mse.usermanagement.service.BlogService;
import mse.usermanagement.service.CommentService;

@Named
@SessionScoped
public class BlogDetailsController implements Serializable {
	private Blog blog;

	private Comment comment;

	@Inject
	private BlogService blogService;

	@Inject
	private CommentService commentService;

	@Inject
	private IdentityController identityController;

	private Long id;

	private List<Comment> comments;

	private String publisher;

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
		comment = new Comment();
	}

	public String addComment() {
		comment.setPublisher(identityController.getCurrentUser().getUsername());
		comment.setDatePublished(new Date());
		comment.setBlogId(blog.getId());
		commentService.save(comment);

		loadComments();

		return "blogDetails?id=" + blog.getId() + "&faces-redirect=true";

	}

	public String deleteComment(Comment comment) {
		commentService.delete(comment);
		loadComments();

		return "blogDetails?id=" + blog.getId() + "&faces-redirect=true";
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

	public IdentityController getIdentityController() {
		return identityController;
	}

	public void setIdentityController(IdentityController identityController) {
		this.identityController = identityController;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
