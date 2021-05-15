package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.UserDAO;
import logger.TestLog4jServlet;
import model.User;



@WebServlet(urlPatterns = { "/insert","/list","/edit","/update","/new","/delete"})

public class UserServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(UserServlet.class);
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {LOGGER.info("operation successfull");
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {LOGGER.error("error occoured");
			throw new ServletException(ex);
		}
	}



	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("choices.html");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String apdate = request.getParameter("apdate");
		String aptime = request.getParameter("aptime");
		String phoneno = request.getParameter("phoneno");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String disease = request.getParameter("disease");
		User newUser = new User( apdate, aptime,phoneno,gender,username,disease);
		int rowsUpdateCount = 0;
		rowsUpdateCount = userDAO.insertUser(newUser);
		if(rowsUpdateCount > 0) {
			response.sendRedirect("list");			
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String apdate = request.getParameter("apdate");
		String aptime = request.getParameter("aptime");
		String phoneno = request.getParameter("phoneno");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String disease = request.getParameter("disease");

		User book = new User(id, apdate,aptime,phoneno,gender,username,disease);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");

	}

}
