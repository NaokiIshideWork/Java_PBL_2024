package model;

public class S0025Bean {
	private int sale_id;
	private String sale_date;
	private String name;
	private String category_name;
	private String trade_name;
	private String unit_price;
	private String sale_number;
	private String subtotal;
	private String note;

	public S0025Bean(int sale_id,String sale_date, String name,String category_name,String trade_name,String unit_price,
			String sale_number,String subtotal,String note) {
		this.sale_id = sale_id;
		this.sale_date = sale_date;
		this.name = name;
		this.category_name = category_name;
		this.trade_name = trade_name;
		this.unit_price = unit_price;
		this.sale_number = sale_number;
		this.subtotal = subtotal;
		this.note = note;
	}

	public int getSale_di() {
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

	public String getUnir_price() {
		return unit_price;
	}

	public String getSale_number() {
		return sale_number;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public String getNote() {
		return note;
	}

}
