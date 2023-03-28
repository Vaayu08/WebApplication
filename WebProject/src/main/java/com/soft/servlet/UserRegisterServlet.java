package com.soft.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.tomcat.jni.User;

import com.soft.dao.DBConnection;


@WebServlet("/userRegister")
public class UserRegisterServlet extends GenericServlet{

	private Connection con;
	
	public void init() {
		
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw =  res.getWriter();
		res.setContentType("text/html");
		try {
			
			int userId = Integer.parseInt(req.getParameter("user_id"));
			String userName = req.getParameter("user_name");
			String userEmail = req.getParameter("user_email");
			String Password = req.getParameter("password");
			int contactNumber = Integer.parseInt(req.getParameter("contact_number"));
			String Address = req.getParameter("address");
			
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			
			ps.setInt(1, userId);
			ps.setString(2, userName);
			ps.setString(3, userEmail);
			ps.setString(4, Password);
			ps.setInt(5,contactNumber);
			ps.setString(6, Address);
			
			int k = ps.executeUpdate();
			if (k > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
				rd.forward(req, res);
			} else {
				
				RequestDispatcher rd = req.getRequestDispatcher("userRegister.jsp");
				rd.forward(req, res);
				pw.println("User Not Register sucessfully");
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
