package model;

public class SalesDetailsDisplayBean {
	private int sale_id;
	private String sale_date;
	private String account;
	private String category;
	private String trade_name;
	private String unit_price;
	private String sale_number;
	private String note;

	public SalesDetailsDisplayBean(int sale_id,String sale_date, String account, String category, String trade_name, String unit_price,
			String sale_number, String note) {
		this.sale_id = sale_id;
		this.sale_date = sale_date;
		this.account = account;
		this.category = category;
		this.trade_name = trade_name;
		this.unit_price = unit_price;
		this.sale_number = sale_number;
		this.note = note;
	}

	public int getSale_id() {
		return sale_id;
	}
	public String getSale_date() {
		return sale_date;
	}

	public String getAccount() {
		return account;
	}

	public String getCategory() {
		return category;
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
