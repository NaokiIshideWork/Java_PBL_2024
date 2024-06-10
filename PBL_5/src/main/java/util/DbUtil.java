package util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbUtil {

	public static Connection open() {
		//例外をcatch
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mariadb");
			con = ds.getConnection();
			//System.out.println("接続に成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection close(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//例外をcatch
		return con;
	}
}
