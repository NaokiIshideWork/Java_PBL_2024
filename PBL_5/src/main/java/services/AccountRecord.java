package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbUtil;

public class AccountRecord {

	public static void makeaccount(String name, String mail, String password, int authority) {
		String sql = "insert into accounts (name,mail,password,authority) values(?,?,?,?)";
		try{
			Connection con = DbUtil.open();
			PreparedStatement ps = null;
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,mail);
			ps.setString(3,password);
			ps.setInt(4,authority);			
			ps.executeUpdate();
			System.out.println("insertされました。");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
