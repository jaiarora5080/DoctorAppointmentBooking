package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet(name = "MenuServlet", urlPatterns = { "/menuPage"})
public class MenuServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((request.getParameter("radiob").equals("book")) && (request.getParameter("next") != null)) {
			request.getRequestDispatcher("user-form.jsp").forward(request, response);
		}
          
		

		if ((request.getParameter("radiob").equals("view")) && (request.getParameter("next") != null)) {
			//request.getRequestDispatcher("user-list.jsp").forward(request, response);
			List<User> listUser = userDAO.selectAllUsers();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewap.jsp");
			dispatcher.forward(request, response);
		}
		
		
	if ((request.getParameter("radiob").equals("edit")) && (request.getParameter("next") != null)) {
		//request.getRequestDispatcher("user-list.jsp").forward(request, response);
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
}
	
	
	
	
	
	
}
