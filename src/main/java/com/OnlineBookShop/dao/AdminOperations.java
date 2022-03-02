package com.OnlineBookShop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminOperations {
	DBConnectivity db = new DBConnectivity();
	Connection conn = db.dbconnection();

	public boolean login(String li, String pwd) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from admin_details where Login_Id=? && password=?");
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
					+ rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getDouble(6));
		}
	}

	public boolean AddBooks(String bsno, String bname, String aname, int pg, int st, int amt)
			throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into book_details values(?,?,?,?,?,?)");
		ps.setString(1, bsno);
		ps.setString(2, bname);
		ps.setString(3, aname);
		ps.setInt(4, pg);
		ps.setInt(5, st);
		ps.setDouble(6, amt);

		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0)
			return true;
		else
			return false;
	}

	public boolean delete(String bc) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from book_details where Book_Serialno = ?");
		ps.setString(1, bc);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean profileSetting(String eid, String name, String pwd) throws SQLException {
		PreparedStatement ps = conn
				.prepareStatement("update  admin_details  set Name=?,password=? where emp_Id=?");
		ps.setString(1, name);
		ps.setString(2, pwd);
		ps.setString(3, eid);
		int affectedRows = ps.executeUpdate();

		if (affectedRows > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean logout() throws SQLException {
		conn.close();
		return true;
	}

}
