package core;

import java.time.LocalDate;

import enums.Brand;
import enums.Color;
import enums.Material;


public class Pen {
	private int id;
	private Color color;
	private Material material;
	private Brand brand;
	private int stock;
	private LocalDate stockUpdateDate;
	private LocalDate listingDate;
	private int price;
	private int discountPercent;

	private static int DEFAULT;

	static {
		DEFAULT = 100;
	}

	public static int idGenerator() {
		return ++DEFAULT;
	}

	public Pen(Color color, Material material, Brand brand, LocalDate stockUpdateDate, int price, int stock) 
	{
		super();
		this.id = idGenerator();
		this.stock = stock;
		this.color = color;
		this.material = material;
		this.brand = brand;
		this.stockUpdateDate = stockUpdateDate;
		this.listingDate = LocalDate.now();
		this.price = price;
		this.discountPercent = 0;
	}


	public int getStock()
	{
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
		this.setStockUpdateDate(LocalDate.now());
	}

	public LocalDate getUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public LocalDate getListingDate() {
		return listingDate;
	}

	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
		this.price = price * (discountPercent/100);
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", color=" + color + ", material=" + material + ", brand=" + brand + ", stock=" + stock
				+ ", stockUpdateDate=" + stockUpdateDate + ", listingDate=" + listingDate + ", price=" + price
				+ ", discountPercent=" + discountPercent + "]";
	}
}
