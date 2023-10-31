package utils;

import java.util.List;

import core.Category;
import core.DeliveryStatus;
import core.Order;
import core.Pet;
import exceptions.InvalidPetIdException;
import exceptions.StockOutOfBoundException;

public class PetValidations {
	
	public static Pet validateInputs(String name, String cat,double unitPrice,int  stocks) {
		
		System.out.println(cat);
		
		Category category = validateCategory(cat);
		
		return new Pet(name, category, unitPrice, stocks);
		
	}
	
	
	public static Order validateOrder(int id, int quantity, List<Pet> petList) throws InvalidPetIdException, StockOutOfBoundException {
		
		
		Pet p = findById(id, petList);
		
		
		if(p.getStocks() < quantity) {
			throw new StockOutOfBoundException("stock is less than required");
		}
		
		// order a pet
		
		Order order = new Order(id, quantity, DeliveryStatus.PLACED);
		
		
//		update the stock
		p.setStocks(p.getStocks() - quantity);
		
		return order;
		
		
	}

	private static Category validateCategory(String cat) {
		return Category.valueOf(cat);
	}
	
	public static Pet findById(int id, List<Pet> petList) throws InvalidPetIdException {
		
		for(Pet p : petList) {
			if(p.getPetId() == id) {
				return p;
			}
		}
		
		throw new InvalidPetIdException("invalid pet id " + id + " to find Pet by id");
		
	}

}