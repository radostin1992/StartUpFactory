package mse.usermanagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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

import mse.usermanagement.model.User;
import mse.usermanagement.service.UserService;
import mse.usermanagement.servlets.ImageServlet;

/**
 * Controller for the user page.
 * 
 * @author Radostin Ivanov
 *
 */
@Named
@ViewScoped
public class UserController implements Serializable {
	private User user;

	private String verifyPassword;

	private Boolean termsAccepted;

	private Long id;

	private Part image;

	@Inject
	private UserService userService;

	public void onPageLoad() {
		if (id != null) {
			user = userService.getUser(id);
			verifyPassword = user.getPassword();
			termsAccepted = true;
		} else {
			user = new User();
		}
	}

	public void checkForExistingUser(FacesContext context, UIComponent component, Object value) {
		String username = (String) value;
		if (userService.getUserByUsername(username) != null) {
			FacesMessage message = createMessage("user_already_exist", context);
			throw new ValidatorException(message);
		}

	}

	/**
	 * Performs validation for password verification, accepted terms of use and
	 * persist the user data if validation passes.
	 * 
	 * @return navigation to the users list page. Return null(redisplay the
	 *         page) if validation fails.
	 * @throws IOException
	 */
	public String save() throws IOException {
		boolean passwordMatches = verifyPassword.equals(user.getPassword());
		if (!passwordMatches) {
			addMessage("userForm:verify-password", "password_mismatch");
			return null;
		}
		if (!termsAccepted) {
			addMessage("userForm:terms", "terms_not_accepted");
			return null;
		}

		if (image != null) {
			String fileName = ImageServlet.getImagesDir() + user.getUsername();

			new File(fileName).delete();

			image.write(fileName);
		}
		userService.save(user);
		return "userList?faces-redirect=true";
	}

	private void addMessage(String componentID, String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMassage = createMessage(key, context);
		context.addMessage(componentID, facesMassage);
	}

	private FacesMessage createMessage(String key, FacesContext context) {
		Locale userLocale = context.getViewRoot().getLocale();

		ResourceBundle messages = ResourceBundle.getBundle("mse.usermanagement.messages.messages", userLocale);
		String message = messages.getString(key);

		FacesMessage facesMassage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		return facesMassage;
	}

	public void validaeImage(FacesContext context, UIComponent component, Object value) {
		Part image = (Part) value;
		if (image != null && !image.getContentType().startsWith("image")) {
			FacesMessage message = createMessage("invalid_image", context);
			throw new ValidatorException(message);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getTermsAccepted() {
		return termsAccepted;
	}

	public void setTermsAccepted(Boolean termsAccepted) {
		this.termsAccepted = termsAccepted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

}
