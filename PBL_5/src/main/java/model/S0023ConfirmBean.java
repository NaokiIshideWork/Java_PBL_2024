package model;

public class S0023ConfirmBean {
	private int sale_id;
	private String sale_date;
	
	private String account;
	private int account_id;
	private String category_name;
	private int category_id;
	
	private String trade_name;
	private String unit_price;
	private String sale_number;
	private String note;

	public S0023ConfirmBean(int sale_id,String sale_date,String account,int account_id,String category_name,int category_id,String trade_name,String unit_price,String sale_number,String note) {
		this.sale_id = sale_id;
		this.sale_date = sale_date;
		this.account = account;
		this.account_id = account_id;
		this.category_name = category_name;
		this.category_id = category_id;
		this.trade_name = trade_name;
		this.unit_price = unit_price;
		this.sale_number = sale_number;
		this.note = note;
	}

	public int getSale_id() {
		return sale_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public String getSale_date() {
		return sale_date;
	}

	public String getAccount() {
		return account;
	}

	public String getCategory_name() {
		return category_name;
	}

	public String getTrade_name() {
		return trade_name;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public String getSale_number() {
		return sale_number;
	}

	public String getNote() {
		return note;
	}
}
