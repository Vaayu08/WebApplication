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

import com.soft.dao.DBConnection;

@WebServlet("/addProduct")
public class AddProductServlet extends GenericServlet {
	
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
			int pid = Integer.parseInt(req.getParameter("pid"));
			String pname = req.getParameter("pname");
			int pqty = Integer.parseInt(req.getParameter("pqty"));
			double price = Double.parseDouble(req.getParameter("pprice"));
			
            PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
			
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setInt(3, pqty);
			ps.setDouble(4, price);
			
			int k = ps.executeUpdate();
			if (k > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				rd.forward(req, res);
			} else {
				
				RequestDispatcher rd = req.getRequestDispatcher("productError.jsp");
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
