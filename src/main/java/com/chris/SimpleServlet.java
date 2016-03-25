package com.chris;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;

@WebServlet(urlPatterns={"/hello"})
public class SimpleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write("The current date is: " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()).toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		if (name != null) {
			if ("".equals(name)) {
				resp.sendRedirect("index.jsp");
			}
			resp.getWriter().write(String.format("Hello %s!", name));
		} else {
			resp.getWriter().write("Please enter a name!");
		}
	}
}
