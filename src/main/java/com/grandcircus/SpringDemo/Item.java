package com.grandcircus.SpringDemo;

public class Item {
	private String item_name;
	private String description;
	private int quantity;
	private int price;
	public Item() {}
	public Item(String a, String b, int c, int d) {
		item_name = a;
		description = b;
		quantity = c;
		price = d;
	}
	// getters
	public String getitem_name() {
		return item_name;
	}
	public String getName() {
		return getitem_name();
	}
	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	}
	// setters
	public void setitem_name(String _name) {
		item_name = _name;
	}
	public void setDescription(String _description) {
		description = _description;
	}
	public void setQuantity(int _quantity) {
		quantity = _quantity;
	}
	public void setPrice(int _price) {
		price = _price;
	}
	// misc
	@Override
	public String toString() {
		return item_name + " (desc: " + "\"" + description + "\"" + ")" + " (quantity: x" + quantity + ")" + " (price: $" + price + ")";
	}
	// fun
	public String getImage() {
		switch (item_name) {
			case "GC Guidebook":
			case "GC Workbook": {
				return "http://www.freepngclipart.com/download/books/14128-free-for-books-danasojnm-top-free-download-png.jpg";
			}
			case "GPhone 8": {
				return "https://ss7.vzw.com/is/image/VerizonWireless/iphone7-front-matblk?$png8alpha256$&hei=400";
			}
			case "GC Leather Bag": {
				return "https://cache.net-a-porter.com/images/products/904750/904750_in_pp.jpg";
			}
			case "Aromatic Coffee Beans": {
				return "https://discoverdiscomfort.com/wp-content/uploads/2019/03/Arabic-Coffee-a-Complete-Guide-for-Coffee-Nerds-Turkish-Coffee-on-table--1024x683.jpg";
			}
			default: {
				return "";
			}
		}
	}
}
