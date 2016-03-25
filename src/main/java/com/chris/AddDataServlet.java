package com.chris;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisteredUser user = (RegisteredUser)request.getSession().getAttribute("userInfo");
		if (user == null) {
			response.sendRedirect("/SimpleServletTest/login");
			return;
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adddata.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisteredUser user = (RegisteredUser)request.getSession().getAttribute("userInfo");
		if (user == null) {
			response.sendRedirect("/SimpleServletTest/login");
			return;
		}
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		DataRecord dataRec = new DataRecord(name, date, description, quantity, price);
		int userId = 0;
		if (user != null) {
			userId = user.getId();
		}
		dataRec.setUserid(userId);
		session.save(dataRec);
		
		session.getTransaction().commit();
		session.close();
		
		response.sendRedirect("/SimpleServletTest/DataServlet");
	}

}
