package cn.cwx521.dao.impl;


import cn.cwx521.DAO1.UserDAO;
import cn.cwx521.model.User;
import cn.cwx521.untils.JDBCUtils;

public class UserDAOImpl implements UserDAO {

	public void saveUser(User u) {
			String sql="INSERT INTO user(username,pass) VALUES(?,?);";
			JDBCUtils.executeUpdate(sql,u.getUser(),u.getPass());
		
		
		
	}

}
