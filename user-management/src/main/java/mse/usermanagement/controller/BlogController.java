package mse.usermanagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import mse.usermanagement.model.Blog;
import mse.usermanagement.service.BlogService;
import mse.usermanagement.servlets.ImageServlet;

@Named
@ViewScoped
public class BlogController implements Serializable {

	private Blog blog;

	private Long id;

	private Date date;

	private Part image;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Inject
	private BlogService blogService;

	@Inject
	private IdentityController identityController;

	public void onPageLoad() {
		if (id != null) {
			blog = blogService.getBlog(id);

		} else {
			blog = new Blog();
		}
	}

	public String getUsername() {
		String username = identityController.getCurrentUser().getUsername();
		return username;
	}

	public void checkForExistingBlog(FacesContext context, UIComponent component, Object value) {
		String title = (String) value;
		if (blogService.getBlogByTitle(title) != null) {
			FacesMessage message = createMessage("title_already_exist", context);
			throw new ValidatorException(message);
		}
	}

	public String save() throws IOException {
		if (image != null) {
			String fileName = ImageServlet.getImagesDir() + blog.getTitle();

			new File(fileName).delete();

			image.write(fileName);
		}
		if (blog.getAuthor() == null) {
			blog.setAuthor(identityController.getCurrentUser().getUsername());
		}
		if (blog.getDate() == null) {
			blog.setDate(getCurrentDate());
			blog.setLastModified(getCurrentDate());
		} else {
			blog.setLastModified(getCurrentDate());
		}

		blogService.save(blog);
		return "blogList?faces-redirect=true";
	}

	public Date getCurrentDate() {
		Date d = new Date();
		date = d;
		return date;

	}

	public void validateImage(FacesContext context, UIComponent component, Object value) {
		Part image = (Part) value;
		if (image != null && !image.getContentType().startsWith("image")) {
			FacesMessage message = createMessage("invalid_image", context);
			throw new ValidatorException(message);
		}
	}

	private FacesMessage createMessage(String key, FacesContext context) {
		Locale userLocale = context.getViewRoot().getLocale();

		ResourceBundle messages = ResourceBundle.getBundle("mse.usermanagement.messages.messages", userLocale);
		String message = messages.getString(key);

		FacesMessage facesMassage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		return facesMassage;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
