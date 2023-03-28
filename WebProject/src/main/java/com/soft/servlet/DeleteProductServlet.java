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
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends GenericServlet {

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
			
			PreparedStatement ps = con.prepareStatement("delete from product where pid=?");
			ps.setInt(1, pid);
			
			int k = ps.executeUpdate();
			if(k>0) {
				pw.print("Record Deleted");
				RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				rd.include(req, res);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				rd.include(req, res);
				pw.println("Record Not Deleted...");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
