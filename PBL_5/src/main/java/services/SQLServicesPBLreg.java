package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccountsBean;
import model.CategoriesBean;
import util.DbUtil;

public class SQLServicesPBLreg {

	public static String unescapeHtml(String escapedString) {
		return escapedString
				.replace("&lt;", "<")
				.replace("&gt;", ">")
				.replace("&amp;", "&")
				.replace("&quot;", "\"")
				.replace("&apos;", "'");
	}

	public ArrayList<CategoriesBean> canSelectAllCategory() {
		String sql = "SELECT * FROM categories WHERE active_flg = 1;";
		ArrayList<CategoriesBean> categories_list = new ArrayList<CategoriesBean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int category_id = rs.getInt("category_id");
				String category_name = rs.getString("category_name");
				int active_flg = rs.getInt("active_flg");

				categories_list.add(new CategoriesBean(category_id, category_name, active_flg));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories_list;
	}

	public ArrayList<AccountsBean> canSelectAllAcount() {
		String sql = "SELECT * FROM accounts; ";
		ArrayList<AccountsBean> account_list = new ArrayList<AccountsBean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int account_id = rs.getInt("account_id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				int authority = rs.getInt("authority");

				account_list.add(new AccountsBean(account_id, name, mail,
						password, authority));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account_list;
	}

	public String SelectRegName(int account_id) {
		String sql = "SELECT NAME FROM accounts WHERE account_id = ?;";
		String accountName = "";
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, account_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				accountName = name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountName;
	}

	public String SelectCategory_Name(int category_id) {
		String sql = "SELECT category_name FROM categories WHERE category_id = ?";
		String category_name = "";
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, category_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				String name = rs.getString("category_name");
				category_name = name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category_name;
	}

	public void insert(String sale_date, int account_id, int category_id, String trade_name, int unit_price,
			int sale_number, String note) {
		String sql = "insert into sales(sale_date,account_id, category_id, trade_name, unit_price, sale_number, note) values(?, ?, ?, ?,?,?,?)";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, sale_date);
			ps.setInt(2, account_id);
			ps.setInt(3, category_id);
			ps.setString(4, unescapeHtml(trade_name));
			ps.setInt(5, unit_price);
			ps.setInt(6, sale_number);
			ps.setString(7, note);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
