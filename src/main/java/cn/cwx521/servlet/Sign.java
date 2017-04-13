package cn.cwx521.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cwx521.model.User;
import cn.cwx521.service.UserService;
import cn.cwx521.service.impl.UserServiceImp;
import cn.cwx521.untils.BeanUtils;

@WebServlet(urlPatterns =  "/sign")
public class Sign extends HttpServlet {
	private UserService us = new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");// post����
		//���������������װbean
		User u = (User) BeanUtils.createBean(req.getParameterMap(), User.class);
		us.addUser(u);
		resp.setCharacterEncoding("UTF-8");//�������ݵ�post����
		resp.getWriter().write("ע��ɹ�");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
