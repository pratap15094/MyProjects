package com.user.services;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAllUser();

	public User getUser(String userId);

}
