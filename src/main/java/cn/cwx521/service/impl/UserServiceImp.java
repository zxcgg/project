package cn.cwx521.service.impl;

import cn.cwx521.DAO1.UserDAO;
import cn.cwx521.dao.impl.UserDAOImpl;
import cn.cwx521.model.User;
import cn.cwx521.service.UserService;

public class UserServiceImp implements UserService {
private UserDAO userDao= new UserDAOImpl();
	public void addUser(User u) {
		userDao.saveUser(u);
	}

}
