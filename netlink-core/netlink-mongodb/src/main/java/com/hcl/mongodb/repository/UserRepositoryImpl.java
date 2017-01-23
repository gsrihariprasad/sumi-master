package com.hcl.mongodb.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User findByUserName(String username) {

		User user = mongoTemplate.findOne(query(where("userName").is(username)),
				User.class,"User");
		// mongoTemplate.find(query, entityClass)
		return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		mongoTemplate.save(user);
	}

}
