package com.app.views;

import java.util.ArrayList;
import java.util.List;

import com.app.entities.User;
import com.jk.web.faces.controllers.JKWebController;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("indexview")
@ViewScoped
public class IndexView extends JKWebController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();

	private List<User> users;

	@PostConstruct
	public void init() {
		users = new ArrayList<User>();
	}

	public void showFullName() {
		User user1 = new User();
		user1.setfName(user.getfName());
		user1.setlName(user.getlName());
		user1.setAge(user.getAge());
		users.add(user1);
		user.setfName("");
		user.setlName("");
		user.setAge(0);
	}

	public void deleteList() {
		System.out.println("deleted all users: " + users);
		users.removeAll(users);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
