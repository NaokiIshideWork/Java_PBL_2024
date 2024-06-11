package model;

public class AccountsBean {

	private int account_id;
	private String name;
	private String mail;
	private String password;
	private int authority;

	public AccountsBean(int ai, String n, String m, String p, int au) {
		account_id = ai;
		name = n;
		mail = m;
		password = p;
		authority = au;
	}

	public int getAccount_id() {
		return account_id;
	}

	public String getName() {
		return name;
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
