import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import controller1.Dbutil;

public class AccountRecord {

	public static void makeaccount(String name, String mail, String password, int authority) {
		String sql = "insert into accounts (name,email,password,authority) values(?,?,?,?)";
		try{
			Connection con = Dbutil.open();
			PreparedStatement ps = null;
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,mail);
			ps.setString(3,password);
			ps.setString(4,authority);			
			ps.executeUpdate();
			System.out.println("insertされました。");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(NamingException n) {
			n.printStackTrace();
		}
	}

}
