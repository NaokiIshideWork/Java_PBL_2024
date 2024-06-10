package model;

import java.sql.Date;

public class SalesBean {
	
	private int sale_id;
	private Date sale_date;
	private int account_id;
	private int category_id;
	private String trade_name;
	private int unit_price;
	private int sale_number;
	private String note;
	
	public SalesBean(int si,Date sd,int ai,int ci,String tn,int up,int sn,String n) {
		sale_id=si;
		sale_date=sd;
		account_id=ai;
		category_id=ci;
		trade_name=tn;
		unit_price=up;
		sale_number=sn;
		note=n;
		
	}

	public int getSale_id() {
		return sale_id;
	}

	public Date getSale_date() {
		return sale_date;
	}

	public int getAccount_id() {
		return account_id;
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

	public String getNote() {
		return note;
	}
	
	

}
