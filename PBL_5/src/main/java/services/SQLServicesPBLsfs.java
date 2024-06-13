package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;

import model.AccountsBean;
import model.S0023Bean;
import model.S0025Bean;
import model.Sales2Bean;
import model.SalesDetailsDisplayBean;
import model.SalesSearchDisplayBean;
import util.DbUtil;

public class SQLServicesPBLsfs {
	//三桁区切り
	public static final String formatNumber(long num) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		return nf.format(num);
	}

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

	public ArrayList<Sales2Bean> selectAllSales(String salesDateB, String salesDateA, String salesPerson,
			String productCategory,
			String productName, String remarks) {
		String sql = "SELECT * FROM sales WHERE sale_date >=? and sale_date <= ? and account_id = ? and category_id = ? and trade_name LIKE ? AND note LIKE ?;";
		ArrayList<Sales2Bean> account_list = new ArrayList<Sales2Bean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {
			System.out.println("->" + productName);

			ps.setString(1, salesDateB);
			ps.setString(2, salesDateA);
			ps.setString(3, salesPerson);
			ps.setString(4, productCategory);
			ps.setString(5, "%" + productName + "%");
			ps.setString(6, "%" + remarks + "%");

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

	public ArrayList<SalesSearchDisplayBean> SalesSearchDisplay(String salesDateB, String salesDateA,
			String salesPerson, String productCategory,
			String productName, String remarks) {
		String sql = "SELECT s.sale_id, s.sale_date,a.name,c.category_name,s.trade_name,s.unit_price,s.sale_number,(s.unit_price*s.sale_number)AS subtotal FROM sales s \n"
				+ "LEFT OUTER JOIN accounts a ON s.account_id = a.account_id\n"
				+ "LEFT OUTER JOIN categories c ON s.category_id = c.category_id \n"
				+ "WHERE sale_date >= ? and sale_date <= ? AND\n"
				+ "s.account_id = ? AND s.category_id = ? AND trade_name LIKE ? AND note LIKE ?;";
		ArrayList<SalesSearchDisplayBean> account_list = new ArrayList<SalesSearchDisplayBean>();
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, salesDateB);
			ps.setString(2, salesDateA);
			ps.setString(3, salesPerson);
			ps.setString(4, productCategory);
			ps.setString(5, "%" + productName + "%");
			ps.setString(6, "%" + remarks + "%");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int sale_id = rs.getInt("sale_id");
				String sale_date = rs.getString("sale_date");
				String name = rs.getString("name");
				String category_name = rs.getString("category_name");
				String trade_name = rs.getString("trade_name");
				int unit_price = rs.getInt("unit_price");
				int sale_number = rs.getInt("sale_number");
				int subtotal = rs.getInt("subtotal");

				account_list.add(new SalesSearchDisplayBean(sale_id, sale_date, name, category_name,
						trade_name, formatNumber(unit_price), formatNumber(sale_number), formatNumber(subtotal)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account_list;
	}

	public SalesDetailsDisplayBean SalesDetailsDisplay(int salesearch_id) {
		String sql = "SELECT s.sale_id, s.sale_date,a.name,c.category_name,s.trade_name,s.unit_price,s.sale_number,\n"
				+ " s.note from sales s \n"
				+ "LEFT OUTER JOIN accounts a ON s.account_id = a.account_id\n"
				+ "LEFT OUTER JOIN categories c ON s.category_id = c.category_id \n"
				+ "WHERE s.sale_id  =? ;";

		SalesDetailsDisplayBean SalesDeetail_list = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, salesearch_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int sale_id = rs.getInt("sale_id");
				String sale_date = rs.getString("sale_date");
				String name = rs.getString("name");
				String category_name = rs.getString("category_name");
				String trade_name = rs.getString("trade_name");
				int unit_price = rs.getInt("unit_price");
				int sale_number = rs.getInt("sale_number");
				String note = rs.getString("note");

				SalesDeetail_list = new SalesDetailsDisplayBean(sale_id, sale_date, name, category_name, trade_name,
						formatNumber(unit_price), formatNumber(sale_number), note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SalesDeetail_list;
	}

	public S0025Bean SalesDetailsDelete(int salesearch_id) {
		String sql = "SELECT s.sale_id,s.sale_date,a.name,c.category_name,s.trade_name,s.unit_price,s.sale_number,\n"
				+ " (s.unit_price*s.sale_number)AS subtotal ,s.note from sales s \n"
				+ "LEFT OUTER JOIN accounts a ON s.account_id = a.account_id\n"
				+ "LEFT OUTER JOIN categories c ON s.category_id = c.category_id \n"
				+ "WHERE s.sale_id  =? ;";

		S0025Bean S0025Bean_list = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, salesearch_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int sale_id = rs.getInt("sale_id");
				String sale_date = rs.getString("sale_date");
				String name = rs.getString("name");
				String category_name = rs.getString("category_name");
				String trade_name = rs.getString("trade_name");
				int unit_price = rs.getInt("unit_price");
				int sale_number = rs.getInt("sale_number");
				int subtotal = rs.getInt("subtotal");
				String note = rs.getString("note");

				S0025Bean_list = new S0025Bean(sale_id,sale_date, name, category_name, trade_name,
						formatNumber(unit_price), formatNumber(sale_number), formatNumber(subtotal), note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return S0025Bean_list;
	}
	
	//削除追加
	
	public void delete(int delete_id) {
		String sql = "DELETE FROM sales WHERE sale_id = ?";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, delete_id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public S0023Bean SalesEdit(int sales_id) {
		String sql = "SELECT s.sale_id,s.sale_date,a.name,c.category_name,s.trade_name,s.unit_price,s.sale_number,\n"
				+ " (s.unit_price*s.sale_number)AS subtotal ,s.note from sales s \n"
				+ "LEFT OUTER JOIN accounts a ON s.account_id = a.account_id\n"
				+ "LEFT OUTER JOIN categories c ON s.category_id = c.category_id \n"
				+ "WHERE s.sale_id  =? ;";

		S0023Bean  S0023Bean_list = null;
		try (
				Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, sales_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int sale_id = rs.getInt("sale_id");
				String sale_date = rs.getString("sale_date");
				String name = rs.getString("name");
				String category_name = rs.getString("category_name");
				String trade_name = rs.getString("trade_name");
				int unit_price = rs.getInt("unit_price");
				int sale_number = rs.getInt("sale_number");
				String note = rs.getString("note");

				S0023Bean_list = new S0023Bean (sale_id,sale_date, name, category_name, trade_name,
						formatNumber(unit_price), formatNumber(sale_number), note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return S0023Bean_list;
	}
	
	public void insert() {
		String sql = "UPDATE sales AS s\n"
				+ "LEFT JOIN accounts AS a ON s.account_id = a.account_id\n"
				+ "LEFT JOIN categories AS c ON s.category_id = c.category_id\n"
				+ "SET s.sale_date = ?,\n"
				+ "    a.name = ?,\n"
				+ "    c.category_name = ?,\n"
				+ "    s.trade_name = ?,\n"
				+ "    s.unit_price = ?,\n"
				+ "    s.sale_number = ?,\n"
				+ "    s.note = ?\n"
				+ "WHERE s.sale_id = ?;";
		try (Connection con = DbUtil.open();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, title);
			ps.setString(2, priority);
			ps.setString(3, term);
			ps.setString(4, contents);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
