package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.CustomerDao;
import model.Customer;

@WebServlet(name = "CustomerServlet", urlPatterns = { "/register" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(CustomerServlet.class);
	private static CustomerDao customersDao = new CustomerDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailid = request.getParameter("emailid");
		String phoneno = request.getParameter("phoneno");
		String date = request.getParameter("date");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);

		System.out.println(phoneno + date);
		Customer customers = new Customer();
		customers.setFirstName(firstName);
		customers.setLastName(lastName);
		customers.setEmailid(emailid);
		customers.setPhoneno(phoneno);
		customers.setDate(date);
		customers.setGender(gender);
		customers.setUsername(username);
		customers.setPassword(password);

		if (request.getParameter("signup") != null) {

			try {LOGGER.info("signup successfull");
				int result = customersDao.registerCustomer(customers);
				if (result > 0) {
					request.getRequestDispatcher("login.html").forward(request, response);
				}

			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.error("signup unsuccessfull");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("login") != null) {
			try {LOGGER.info("login successfull");
				boolean result = customersDao.loginUser(username, password);
				if(result==true)
				{
					request.getRequestDispatcher("choices.html").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {LOGGER.error("login unsuccessfull");
				e.printStackTrace();
			}
		}
	}

}
