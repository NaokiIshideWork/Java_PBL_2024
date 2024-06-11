package model;

public class Sales2Bean {
	int sale_id;
	String sale_date;
	int account_id;
	int category_id;
	String trade_name;
	int unit_price;
	int sale_number;
	String note;
	
	public Sales2Bean(int si,String sd,int ai,int ci,String tn,int up,int sn, String n) {
		sale_id=si;
		sale_date=sd;
		account_id=ai;
		category_id=ci;
		trade_name=tn;
		unit_price=up;
		sale_number=sn;
		note=n;
	}
	

}
