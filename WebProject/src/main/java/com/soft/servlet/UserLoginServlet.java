package com.soft.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.soft.dao.DBConnection;

@WebServlet("/userLogin")
public class UserLoginServlet extends GenericServlet{
private Connection con;
	
	public void init() {
		
		DBConnection dbcon = new DBConnection();
		con = dbcon.createConnection();
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw =  res.getWriter();
		res.setContentType("text/html");
		try {
			String userEmail = req.getParameter("user_email");
			String Password = req.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement("select * from user where user_email=? AND password=?");
			
			ps.setString(1, userEmail);
			ps.setString(2, Password);
			
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	req.setAttribute("userName", rs.getString(2));
            	RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				rd.forward(req, res);
            }else {
            
            	RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
				rd.forward(req, res);
				pw.print("user not login Succesfully...");
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
