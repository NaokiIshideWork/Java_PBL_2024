package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccountsBean;
import model.Sales2Bean;
import util.DbUtil;

public class SQLServicesPBLsfs {
	public ArrayList<AccountsBean> SelectAllAcount() {
		String sql = "SELECT * FROM accounts;";
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

	public ArrayList<Sales2Bean>  selectAllSales(String salesDateB, String salesDateA, String salesPerson, String productCategory,
			String productName, String remarks) {
		String sql = "SELECT * FROM sales WHERE sale_date >=? and sale_date <= ? and account_id = ? and category_id = ? and trade_name LIKE ? AND note LIKE ?;";
		ArrayList<Sales2Bean> account_list = new ArrayList<Sales2Bean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			System.out.println("->"+productName);
			
			ps.setString(1, salesDateB);
			ps.setString(2, salesDateA);
			ps.setString(3, salesPerson);
			ps.setString(4, productCategory);
			ps.setString(5, "%"+productName+"%");
			ps.setString(6, "%"+remarks+"%");

			System.out.println(productName + remarks);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int sale_id = rs.getInt("sale_id");
				String sale_date = rs.getString("sale_date");
				int account_id = rs.getInt("account_id");
				int category_id = rs.getInt("category_id");
				String trade_name = rs.getString("trade_name");
				int unit_price = rs.getInt("unit_price");
				int sale_number = rs.getInt("sale_number");
				String note = rs.getString("note");

				account_list.add(new Sales2Bean(sale_id, sale_date, account_id,
						category_id, trade_name, unit_price, sale_number, note));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account_list;
	}
}
