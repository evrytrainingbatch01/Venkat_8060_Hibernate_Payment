package com.evry.payment.wallet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evry.payment.wallet.dao.PaymentDao;
import com.evry.payment.wallet.model.CustomerRegistration;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaymentDao paymentDao = new PaymentDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("signup".equals(request.getParameter("type"))) {
			setRegistrationData(request, response);
		}
		if ("adminlogin".equals(request.getParameter("type"))) {
			getAdminMenu(request, response);
		}
		if ("userlogin".equals(request.getParameter("type"))) {
			getUserMenu(request, response);
		}
		if ("addMoney".equals(request.getParameter("type"))) {
			addMoney(request, response);
		}
	}

	private void addMoney(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		CustomerRegistration payment = new CustomerRegistration();
		int money = Integer.parseInt(request.getParameter("money"));
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("userId");
		if ( money > 0) {
			if(paymentDao.setBalance(id, money)) {
				out.print("It is in process.");
			request.getRequestDispatcher("/addMoney.jsp").include(request, response);
			}
			else {
				out.print("Money is not added in your account.");
				request.getRequestDispatcher("/addMoney.jsp").forward(request, response);
			}

		} else {
			out.print("Please enter the amount more than zero.");
			request.getRequestDispatcher("/addMoney.jsp").forward(request, response);
		}
	
	}

	private void getAdminMenu(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		CustomerRegistration payment = new CustomerRegistration();
		String name = request.getParameter("fname");
		String pwd = request.getParameter("pwd");
		int id = paymentDao.getMenu(name, pwd);
		if (id > 0) {
			out.print("Welcome " + name);
			HttpSession session = request.getSession();
			session.setAttribute("adminId", id);
			request.getRequestDispatcher("/adminMenu.jsp").include(request, response);

		} else {
			out.print("User does not existed.");
			request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
		}
	}

	private void getUserMenu(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		CustomerRegistration payment = new CustomerRegistration();
		String name = request.getParameter("fname");
		String pwd = request.getParameter("pwd");
		int id = paymentDao.getMenu(name, pwd);
		if ( id > 0) {
			out.print("Welcome " + name);
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			request.getRequestDispatcher("/userMenu.jsp").include(request, response);

		} else {
			out.print("User does not existed.");
			request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
		}
	}

	private void setRegistrationData(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		CustomerRegistration payment = new CustomerRegistration();
		payment.setId(Integer.parseInt(request.getParameter("id")));
		payment.setFname(request.getParameter("fname"));
		payment.setLname(request.getParameter("lname"));
		payment.setPwd(request.getParameter("pwd"));
		payment.setCity(request.getParameter("city"));
		payment.setCountry(request.getParameter("country"));
		payment.setMobile(request.getParameter("mobile"));
		payment.setEmail(request.getParameter("email"));
		if (paymentDao.setData(payment)) {
			out.print("Data is stored in Database");
			request.getRequestDispatcher("/signup.jsp").include(request, response);

		} else {
			out.print("Data is not stored in Database");
			request.getRequestDispatcher("/signup.jsp").forward(request, response);
		}
	}

}
