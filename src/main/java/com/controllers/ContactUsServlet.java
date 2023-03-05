package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.RequestDao;
import com.models.Request;

@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("contactUs.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		Request user = new Request();
		user.setName(name);
		user.setEmail(email);
		user.setMessage(message);
		
		RequestDao.saveRequest(user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("successfulSubmission.jsp");
		requestDispatcher.forward(request, response);
	}
}
