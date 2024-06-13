package model;

public class SalesSearchBean {
	private String salesDateB;
	private String salesDateA;
	private String personName;
	private String item_category;
	private String productName;
	private String remarks;
	
	public SalesSearchBean(String salesDateB,String salesDateA,String personName,String item_category,String productName,String remarks)
	{
		this.salesDateB = salesDateB;
		this.salesDateA = salesDateA;
		this.personName = personName;
		this.item_category = item_category;
		this.productName = productName;
		this.remarks = remarks;
	}

	public String getSalesDateB() {
		return salesDateB;
	}

	public String getSalesDateA() {
		return salesDateA;
	}

	public String getPersonName() {
		return personName;
	}

	public String getItem_category() {
		return item_category;
	}

	public String getProductName() {
		return productName;
	}

	public String getRemarks() {
		return remarks;
	}

}
