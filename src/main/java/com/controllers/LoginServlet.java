package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.UserDao;
import com.models.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		User admin = new User();
		admin.setUserName(userName);
		admin.setPassWord(passWord);
		
		boolean isValidCredential = UserDao.isAdmin(admin);
		if(isValidCredential) {
			response.sendRedirect("DashboardServlet");
		}
		else {
			out.println("Wrong Password");
			response.sendRedirect("login.jsp");
		}
	}
}
