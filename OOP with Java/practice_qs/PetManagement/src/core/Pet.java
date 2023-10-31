package core;

public class Pet {
	
//	Pet ( petId, name, category, unitPrice, stocks)
	
	static int idGenerator;
	int petId;
	String name;
	Category cat;
	double unitPrice;
	int stocks;
	
	
	static {
		idGenerator = 1;
	}
	
	
//	Constructor to initialized state of object
	
	public Pet(String name, Category cat, double unitPrice, int stocks) {
		
		this.petId = Pet.idGenerator++;
		this.name = name;
		this.cat = cat;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}
	
	
	
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", cat=" + cat + ", unitPrice=" + unitPrice + ", stocks="
				+ stocks + "]";
	}
	
	
}
