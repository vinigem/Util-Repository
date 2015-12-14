package com.vini.mysite.core.si;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vini.mysite.core.dao.IUserDao;
import com.vini.mysite.core.ec.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public User findById(long id) {
		return userDao.findById(id);
	}

}
