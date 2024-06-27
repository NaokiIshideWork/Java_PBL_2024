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
	    String sql = "INSERT INTO accounts (name, mail, password, authority) VALUES (?, ?, ?, ?)";
	    Connection con = null;
	    PreparedStatement ps = null;
	    try {
	        con = DbUtil.open();
	        ps = con.prepareStatement(sql);
	        ps.setString(1, name);
	        ps.setString(2, mail);
	        ps.setString(3, password);
	        ps.setInt(4, authority);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // 呼び出し元にエラーを伝えるか、適切に処理する
	    } finally {
	        // リソースの解放
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
	}
	
	public void updateAccount(int id, String name, String mail, String password, int authority) {
				String sql = "UPDATE accounts SET name=?, mail=?, password=?, authority=? WHERE account_id = ?";
				try{
					Connection con = DbUtil.open();
					PreparedStatement ps = null;
					ps = con.prepareStatement(sql);
					ps.setString(1,name);			
					ps.setString(2,mail);			
					ps.setString(3, password);
					ps.setInt(4, authority);
					ps.setInt(5, id);
					ps.executeUpdate();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
	}
	
	public void deleteAccount(String id) {
		String sql = "DELETE FROM accounts WHERE account_id = ?";
		try{
			Connection con = DbUtil.open();
			PreparedStatement ps = null;
			ps = con.prepareStatement(sql);
			ps.setString(1,id);			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	
	// アカウント検索条件入力
	public ArrayList<AccountsBean> EnterAccountSearchCriteria(String name, String mail, int authority) {
		// すべて選択なし
		String AllSQL = "select * from accounts";
		
		
		// all
		ArrayList<AccountsBean> accountsList = new ArrayList<AccountsBean>();
		// 氏名絞り込み
		ArrayList<AccountsBean> accountsList2 = new ArrayList<AccountsBean>();
		// 氏名絞り込み後、メアド絞り込み
		ArrayList<AccountsBean> accountsList3 = new ArrayList<AccountsBean>();
		// 最後に権限での絞り込み
		ArrayList<AccountsBean> accountsList4 = new ArrayList<AccountsBean>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	try {
			con = DbUtil.open();
			ps = con.prepareStatement(AllSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int account_id = rs.getInt("account_id");
				String rs_name = rs.getString("name");
				String rs_mail = rs.getString("mail");
				String password = rs.getString("password");
				int rs_authority = rs.getInt("authority");
				AccountsBean user = new AccountsBean(account_id, rs_name, rs_mail, password, rs_authority);
				accountsList.add(user);
			}
			
			if(accountsList.size() != 0 && name != null) {
				for(AccountsBean ab : accountsList) {
					if(ab.getName() != null && ab.getName().contains(name)) {
						accountsList2.add(ab);
					}
				}
			} else {
				accountsList2 = new ArrayList<>(accountsList);
			}
			
			if(accountsList.size() != 0 && mail != null) {
				for(AccountsBean ab : accountsList2) {
					if(ab.getMail() != null && ab.getMail().equals(mail)) {
						accountsList3.add(ab);
					}
				}
			} else {
				accountsList3 = new ArrayList<>(accountsList2);
			}
			
			if(accountsList.size() != 0 && authority != 99) {
				for(AccountsBean ab : accountsList3) {
					if(ab.getAuthority() != 99 && ab.getAuthority() == authority) {
						accountsList4.add(ab);
					}
					if(authority == 1 && ab.getAuthority() == 11) {
						accountsList4.add(ab);
					}
					if(authority == 10 && ab.getAuthority() == 11) {
						accountsList4.add(ab);
					}
				}
			} else {
				accountsList4 = new ArrayList<>(accountsList3);
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
		return accountsList4;
	}
	
	public ArrayList<AccountsBean> AccountMultiSearchCriteria(String name, String mail, int authority1, int authority2) {
		// すべて選択なし
		String AllSQL = "select * from accounts";
		
		
		// all
		ArrayList<AccountsBean> accountsList = new ArrayList<AccountsBean>();
		// 氏名絞り込み
		ArrayList<AccountsBean> accountsList2 = new ArrayList<AccountsBean>();
		// 氏名絞り込み後、メアド絞り込み
		ArrayList<AccountsBean> accountsList3 = new ArrayList<AccountsBean>();
		// 最後に権限での絞り込み
		ArrayList<AccountsBean> accountsList4 = new ArrayList<AccountsBean>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	try {
			con = DbUtil.open();
			ps = con.prepareStatement(AllSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int account_id = rs.getInt("account_id");
				String rs_name = rs.getString("name");
				String rs_mail = rs.getString("mail");
				String password = rs.getString("password");
				int rs_authority = rs.getInt("authority");
				AccountsBean user = new AccountsBean(account_id, rs_name, rs_mail, password, rs_authority);
				accountsList.add(user);
			}
			
			if(accountsList.size() != 0 && name != null) {
				for(AccountsBean ab : accountsList) {
					if(ab.getName() != null && ab.getName().contains(name)) {
						accountsList2.add(ab);
					}
				}
			} else {
				accountsList2 = new ArrayList<>(accountsList);
			}
			
			if(accountsList.size() != 0 && mail != null) {
				for(AccountsBean ab : accountsList2) {
					if(ab.getMail() != null && ab.getMail().equals(mail)) {
						accountsList3.add(ab);
					}
				}
			} else {
				accountsList3 = new ArrayList<>(accountsList2);
			}
			
			if(accountsList.size() != 0 && authority1 != 999 && authority2 != 999) {
				for(AccountsBean ab : accountsList3) {
					if(ab.getAuthority() != 99 && (ab.getAuthority() == authority1 || ab.getAuthority() == authority2)) {
						accountsList4.add(ab);
					}
					if(( (authority1==1) || (authority2 == 1) ) && ab.getAuthority() == 11) {
						// 重複を回避
						if (!accountsList4.contains(ab)) {
					        accountsList4.add(ab);
					    }
					}
					if(( (authority1==10) || (authority2 == 10) ) && ab.getAuthority() == 11) {
						// 重複を回避
						if (!accountsList4.contains(ab)) {
					        accountsList4.add(ab);
					    }
					}
				}
			} else {
				accountsList4 = new ArrayList<>(accountsList3);
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
		return accountsList4;
	}

}