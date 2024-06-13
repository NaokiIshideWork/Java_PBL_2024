package model;

public class SalesSearchDisplayBean {
	private int sale_id;
	private String sale_date;
	private String name;
	private String category_name;
	private String trade_name;
	private int unit_price;
	private int sale_number;
	private int subtotal;
	
	public SalesSearchDisplayBean(int sale_id,String sale_date,String name,String category_name,String trade_name,int unit_price,int sale_number,int subtotal) {
		this.sale_id = sale_id;
		this.sale_date = sale_date;
		this.name = name;
		this.category_name = category_name;
		this.trade_name = trade_name;
		this.unit_price = unit_price;
		this.sale_number = sale_number;
		this.subtotal = subtotal;
	}

	public int getSale_id() {
		return sale_id;
	}

	public String getSale_date() {
		return sale_date;
	}

	public String getName() {
		return name;
	}

	public String getCategory_name() {
		return category_name;
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
}
