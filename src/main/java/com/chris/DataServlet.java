package com.chris;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet(urlPatterns={"/DataServlet"})
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*DataRecord[] records = new DataRecord[] {
			new DataRecord("Chris", "1-3-3", "This is a description 1", 99, 19.99),
			new DataRecord("John", "1-4-3", "This is a description 2", 55, 29.99),
			new DataRecord("Alexis", "1-5-3", "This is a description 3", 45, 59.99),
			new DataRecord("Susan", "1-6-3", "This is a description 4", 35, 89.99),
			new DataRecord("Sally", "1-7-3", "This is a description 5", 25, 99.99)
		};
		*/
		RegisteredUser user = (RegisteredUser)request.getSession().getAttribute("userInfo");
		if (user == null) {
			response.sendRedirect("/SimpleServletTest/login");
			return;
		}
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		String query = "";
		boolean isAdmin = user.getUsername().equalsIgnoreCase("administrator");
		if (isAdmin) {
			query = "FROM DataRecord WHERE 1=1"; // get ALL records
		} else {
			query = "FROM DataRecord WHERE userid=:userid";
		}
		Query q = session.createQuery(query);
		
		if (! isAdmin) {
			q.setParameter("userid", user.getId());
		}
		
		List<DataRecord> results = q.list();
		Object[] records = results.toArray();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/data.jsp");
		request.setAttribute("data", records);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
