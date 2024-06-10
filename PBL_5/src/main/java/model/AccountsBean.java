package model;

public class AccountsBean {

	private int account_id;
	private String test;
	private String mail;
	private String password;
	private int authority;

	public AccountsBean(int ai, String t, String m, String p, int au) {
		account_id = ai;
		test = t;
		mail = m;
		password = p;
		authority = au;
	}

	public int getAccount_id() {
		return account_id;
	}

	public String getTest() {
		return test;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public int getAuthority() {
		return authority;
	}
	

}
