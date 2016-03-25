package com.chris;

import java.io.IOException;

import org.hibernate.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import java.util.List;

import com.chris.HibernateUtilities;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/LoginServlet", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isLoggedIn = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies)
			{
				if (cookie.getName().equalsIgnoreCase("user-id")) {
					// look up the current user in the DB
					Session session = HibernateUtilities.getSessionFactory().openSession();
					RegisteredUser user = session.load(RegisteredUser.class, Integer.parseInt(cookie.getValue()));
					if (user != null) {
						isLoggedIn = true;
						request.getSession().setAttribute("userInfo", user);
						break;
					}
				}
			}
		}
		
		if (isLoggedIn) {
			response.getWriter().write("User is already logged in! <a href='/SimpleServletTest/home'>Go home</a>");
		} else {
			response.getWriter().write("User is not already logged in. Please login by visiting <a href='/SimpleServletTest/login.jsp'>this link</a>.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isValidLogin = false;
		/*if ("chris".equalsIgnoreCase(username) 
				&& "test".equalsIgnoreCase(password)) {
			Cookie cookie = new Cookie("user-id", "1234");
			cookie.setMaxAge(999999);
			response.addCookie(cookie);
			isValidLogin = true;
		}
		*/
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		String query = "FROM RegisteredUser WHERE username=:username AND password=:password";
		Query q = session.createQuery(query);
		q.setParameter("username", username);
		q.setParameter("password", password);
		List<RegisteredUser> results = q.list();
		if (results.size() > 0) {
			
			Cookie cookie = new Cookie("user-id", new Integer(results.get(0).getId()).toString());
			cookie.setMaxAge(999999);
			response.addCookie(cookie);
			
			isValidLogin = true;
			request.getSession().setAttribute("userInfo", results.get(0));
		}
		
		session.getTransaction().commit();
		session.close();

		if (! isValidLogin) {
			response.getWriter().write("Bad Login. <a href='/SimpleServletTest/login.jsp'>Try again.</a>");
		} else {
			response.getWriter().write("Success! You are now logged in. Go <a href='/SimpleServletTest/home'>home</a>.");
		}
		
		response.flushBuffer();
	}

}
