package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountsBean;
import model.CategoriesBean;
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

	public AllayList<CategoriesBean> SelectAllCategory() {
		String sql = "SELECT * FROM categories WHERE active_flg = 1;";
		CategoriesBean categories_list = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int category_id = rs.getInt("category_id");
				String category_name = rs.getString("category_name");
				int active_flg = rs.getInt("active_flg");

				categories_list = new CategoriesBean(category_id, category_name, active_flg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories_list;
	}

	public AccountsBean SelectAllAccount() {
		String sql = "SELECT * FROM accounts WHERE authority = 1 OR authority =11 ; ";
		AccountsBean account_list = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int account_id = rs.getInt("account_id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				int authority = rs.getInt("authority");

				account_list = new AccountsBean(account_id, name, mail, password, authority);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account_list;
	}

}
