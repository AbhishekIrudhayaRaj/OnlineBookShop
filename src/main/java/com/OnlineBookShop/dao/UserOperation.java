package com.OnlineBookShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserOperation {
	DBConnectivity db = new DBConnectivity();
	Connection conn = db.dbconnection();

	public boolean signUp(String li, String pwd, String name, String loc,String add,  String mail, long ph)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?)");
		ps.setString(1, li);
		ps.setString(2, pwd);
		ps.setString(3, name);
		ps.setString(4, loc);
		ps.setString(5, add);
		ps.setString(6, mail);
		ps.setLong(7, ph);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;

	}

	public boolean login(String li, String pwd) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from customer_details where Login _Id=? && password=?");
		ps.setString(1, li);
		ps.setString(2, pwd);
		ResultSet result = ps.executeQuery();

		if (result.next()) {
			return true;
		} else {
			return false;
		}

	}

	public void viewBooks() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from book_details");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println();
			System.out.println(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
					+ rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getInt(6));
		}
	}

	public boolean addToCart(String sn, int qty) throws SQLException {

		PreparedStatement ps = conn.prepareStatement(
				"insert into cart_details(Book_Serialno,Book_Name,Total_Amount) select Book_Serialno,Book_Name,total_Amount from book_details where Book_Serialno=? ");
		ps.setString(1, sn);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;

	}

	public void viewCart() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from cart_details");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println();
			System.out.println(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}

	}

	public boolean emptyCart(String bsno) throws SQLException {

		PreparedStatement ps = conn.prepareStatement("delete from cart_details where Book_Serialno=?");
		ps.setString(1, bsno);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;

	}

	public boolean orderNow(String bsno, String bn, int qty, String add) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into order_details values(?,?,?,?)");
		ps.setString(1, bsno);
		ps.setString(2, bn);
		ps.setInt(3, qty);
		ps.setString(4, add);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;
	}

	public boolean profileSetting(String li, String pwd, String name, String loc,String add,  String mail, long ph)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?)");
		ps.setString(1, li);
		ps.setString(2, pwd);
		ps.setString(3, name);
		ps.setString(4, loc);
		ps.setString(5, add);
		ps.setString(6, mail);
		ps.setLong(7, ph);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;
	}

	public boolean logout() throws SQLException {
		conn.close();
		return true;
	}
}
