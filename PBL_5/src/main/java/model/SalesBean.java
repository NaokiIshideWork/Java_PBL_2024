package model;

public class SalesBean {

	private String sale_date;
	private String account;
	private int account_id;
	private String item_category;
	private int category_id;
	private String trade_name;
	private int unit_price;
	private int sale_number;
	private int subtotal;
	private String note;

	public SalesBean(String sd, String a, int ai, String ic, int ci, String tn, int up, int sn, int st, String n) {

		sale_date = sd;
		account = a;
		account_id = ai;
		item_category = ic;
		category_id = ci;
		trade_name = tn;
		unit_price = up;
		sale_number = sn;
		subtotal = st;
		note = n;

	}

	public String getSale_date() {
		return sale_date;
	}

	public String getAccout() {
		return account;
	}

	public int getAccout_id() {
		return account_id;
	}

	public String getItem_category() {
		return item_category;
	}

	public int getCategory_id() {
		return category_id;
	}

	public String getTrade_name() {
		return trade_name;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public int getSale_number() {
		return sale_number;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public String getNote() {
		return note;
	}

}
