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

	public ArrayList<CategoriesBean> SelectAllCategory() {
		String sql = "SELECT * FROM categories WHERE active_flg = 1;";
		ArrayList<CategoriesBean> categories_list = new ArrayList<CategoriesBean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
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

	public ArrayList<AccountsBean> SelectAllAcount() {
		String sql = "SELECT * FROM accounts WHERE authority = 1 OR authority =11 ; ";
		ArrayList<AccountsBean> account_list = new ArrayList<AccountsBean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
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
		String accountName  = "";
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			// PreparedStatementがクローズされるタイミングでクローズされる
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
			// PreparedStatementがクローズされるタイミングでクローズされる
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
}
