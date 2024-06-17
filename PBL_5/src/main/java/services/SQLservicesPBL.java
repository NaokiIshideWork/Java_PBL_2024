package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountsBean;
import util.DbUtil;

public class SQLservicesPBL {

	public AccountsBean Login(String in_mail, String in_password) {
		String sql = "SELECT * FROM accounts WHERE mail = ? AND password = ?;";
		AccountsBean person = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる

			ps.setString(1, in_mail);
			ps.setString(2, in_password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int account_id = rs.getInt("account_id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				int authority = rs.getInt("authority");
				person = new AccountsBean(account_id, name, mail, password, authority);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

}
