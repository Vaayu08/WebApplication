package com.soft;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/abc")
public class JDBCConnection extends GenericServlet {
	Connection con = null;

	public void init() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "root", "Siddharth@08");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			String firstname = req.getParameter("fname");
			String lastname = req.getParameter("lname");
			String address = req.getParameter("address");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			PreparedStatement ps = con.prepareStatement("insert into webapp.userdata values(?,?,?,?,?)");

			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, password);

			int k = ps.executeUpdate();
			if (k > 0) {
				pw.println("Data inserted sucessfully");
			} else {
				pw.println("Data not inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
