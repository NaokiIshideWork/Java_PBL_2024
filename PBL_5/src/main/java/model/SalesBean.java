package model;

public class SalesBean {

	private String sale_date;
	private String account;
	private String item_category;
	private String trade_name;
	private int unit_price;
	private int sale_number;
	private int subtotal;
	private String note;

	public SalesBean( String sd, String a,String ic, String tn, int up, int sn,int st,  String n) {
		
		sale_date = sd;
		account=a;
		item_category=ic;
		trade_name = tn;
		unit_price = up;
		sale_number = sn;
		subtotal=st;
		note = n;

	}


	public String getSale_date() {
		return sale_date;
	}
	public String getAccout_id() {
		return account;
	}
	public String getItem_category() {
		return item_category;
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
