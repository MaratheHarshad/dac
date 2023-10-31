package core;

public class Order {
	
//	Order (orderId, petId, quantity, status)
	
	static int orderGenerator = 1;
	
	int orderId;
	int petId;
	int quantity;
	DeliveryStatus status;
	
	
	public Order(int petId, int quantity, DeliveryStatus status) {
		super();
		this.orderId = Order.orderGenerator++;
		this.petId = petId;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

}
