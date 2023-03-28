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
@WebServlet("/editProduct")
public class EditProductServlet extends GenericServlet{

	
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
			
            PreparedStatement ps = con.prepareStatement("update product set pname=?,pqty=?,pprice=? where pid=?");
			
			
			ps.setString(1, pname);
			ps.setInt(2, pqty);
			ps.setDouble(3, price);
			ps.setInt(4, pid);
			
			int k = ps.executeUpdate();
			if (k > 0) {
				pw.print("Producr Update Succesfully....... ");
				RequestDispatcher rd = req.getRequestDispatcher("productDashboard.jsp");
				rd.include(req, res);
			} else {
				pw.print("Producr not Update Succesfully....... ");
				RequestDispatcher rd = req.getRequestDispatcher("editProduct.jsp");
				rd.include(req, res);
				
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
