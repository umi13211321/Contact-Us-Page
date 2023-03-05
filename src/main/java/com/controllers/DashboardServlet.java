package com.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.RequestDao;
import com.models.Request;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Request> activeUsers = RequestDao.getRequestInformation(true);
		List<Request> archivedUsers = RequestDao.getRequestInformation(false);
		request.setAttribute("activeUsers", activeUsers);
		request.setAttribute("archivedUsers", archivedUsers);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao.changeStatus(request.getParameter("id"), request.getParameter("status"));
		response.sendRedirect("DashboardServlet");
	}
}
