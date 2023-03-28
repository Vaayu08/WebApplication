package com.soft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.soft.beans.product;

public class ProductDao {
  
	public List<product> findAllproduct(){
		List<product> productList = new ArrayList<>();
		try {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.createConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from product");
			
			while(rs.next()) {
				product prod = new product();
				prod.setPid(rs.getInt(1));
				prod.setPname(rs.getString(2));
				prod.setPqty(rs.getInt(3));
				prod.setPprice(rs.getDouble(4));
				productList.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}
	public product findBypid(int pid) {
		product exitproduct = new product();
		try {
			DBConnection dbcon = new DBConnection();
			Connection con = dbcon.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from product where pid=?");
			ps.setInt(1 , pid);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				exitproduct.setPid(rs.getInt(1));
				exitproduct.setPname(rs.getString(2));
				exitproduct.setPqty(rs.getInt(3));
				exitproduct.setPprice(rs.getDouble(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return exitproduct;
		
	}


	
}
