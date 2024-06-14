package model;

//sql カテゴリーテーブルをもとに作成
public class CategoriesBean {

	private int category_id;
	private String category_name;
	private int active_flg;

	public CategoriesBean(int ci, String cn, int a) {
		category_id = ci;
		category_name = cn;
		active_flg = a;

	}

	public int getCategory_id() {
		return category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public int getActive_flg() {
		return active_flg;
	}

}
