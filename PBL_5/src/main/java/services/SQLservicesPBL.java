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

	public boolean SearchMail(String in_mail) {
		String sql = "SELECT mail FROM accounts WHERE mail = ?;";
		boolean existMail = false;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる

			ps.setString(1, in_mail);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				existMail = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existMail;
	}

	public boolean SearchPassword(String in_password) {
		String sql = "SELECT password FROM accounts WHERE password = ?;";
		boolean existPassword = false;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, in_password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				existPassword = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existPassword;
	}

}
