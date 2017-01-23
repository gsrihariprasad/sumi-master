package com.hcl.mongodb.repository;

public interface UserRepository {
	
	public User findByUserName(String username);
	public void save(User user);

}
