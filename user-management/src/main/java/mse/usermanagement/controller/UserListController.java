package mse.usermanagement.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import mse.usermanagement.model.User;
import mse.usermanagement.service.UserService;

@Named
@ViewScoped
public class UserListController implements Serializable {

	private static final int MAX_PAGES = 5;

	private List<User> users;

	private Integer page;

	private Integer pageCount;

	@Inject
	private UserService userService;

	public String onPageLoad() {
		if (page == null) {
			return "userList?page=1&faces-redirect=true";
		}
		loadUsers();
		return null;
	}

	public void delete(User user) {
		userService.delete(user);
		loadUsers();
	}

	private void loadUsers() {
		users = userService.getUsers(page);
		pageCount = userService.getPageCount();
	}

	public List<Integer> getPages() {

		List<Integer> numOfPages = new ArrayList<>();

		int pagesToShow = Math.min(MAX_PAGES, pageCount);

		int startPos = page - pagesToShow / 2;

		if (startPos < 1) {
			startPos = 1;
		} else if (startPos + pagesToShow > pageCount) {
			startPos = (pageCount - pagesToShow) + 1;
		}
		for (int i = 0; i < pagesToShow; i++) {
			numOfPages.add(startPos + i);
		}
		return numOfPages;
	}

	public boolean isPrevEnabled() {
		return page > 1;
	}

	public boolean isNextEnabled() {
		return page < pageCount;
	}

	public List<User> getUsers() {
		return users;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

}
