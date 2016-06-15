package mse.usermanagement.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mse.usermanagement.model.User;
import mse.usermanagement.service.UserService;

@Named
@SessionScoped
public class IdentityController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private User currentUser;

	@Inject
	private UserService userService;

	public String login() {
		currentUser = userService.login(username, password);
		if (currentUser == null) {
			return "loginFailed?faces-redirect=true";
		} else {
			return "userList?faces-redirect=true";
		}
	}

	public String logout() {
		currentUser = null;
		return "users?faces-redirect=true";
	}

	public boolean isLoggedIn() {
		return currentUser != null;
	}

	public boolean isCurrentUser(User user) {
		return isLoggedIn() && currentUser.getId().equals(user.getId());
	}

	public boolean isCurrentUserAuthor(String user) {
		return isLoggedIn() && currentUser.getUsername().equals(user);
	}

	public boolean isAdmin() {
		return isLoggedIn() && currentUser.getUsername().equals("admin");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
