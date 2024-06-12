package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccountsBean;
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

	
	// アカウント検索条件入力
	public ArrayList<AccountsBean> EnterAccountSearchCriteria(String name, String mail, int authority) {
		String sql = "SELECT * FROM accounts WHERE name LIKE ? AND mail=? AND authority=?";
		ArrayList<AccountsBean> accountsList = new ArrayList<AccountsBean>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	try {
			con = DbUtil.open();
			ps = con.prepareStatement(sql);
			System.out.println("サービス側" + name);
		    ps.setString(1, "%" + name + "%"); // 名前の部分一致
			ps.setString(2, mail);
			ps.setInt(3, authority);
			System.out.println("サービス側" + authority);
			
			rs = ps.executeQuery();
			
			System.out.println("EnterAccountSearchCriteriaの実行");

			while (rs.next()) {
				int account_id = rs.getInt("account_id");
				String rs_name = rs.getString("name");
				String rs_mail = rs.getString("mail");
				String password = rs.getString("password");
				int rs_authority = rs.getInt("authority");
				AccountsBean user = new AccountsBean(account_id, rs_name, rs_mail, password, rs_authority);
				accountsList.add(user);
				System.out.println(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return accountsList;
	}


}
