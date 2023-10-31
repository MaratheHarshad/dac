package utils;

import java.time.LocalDate;


import core.Pen;
import enums.Brand;
import enums.Color;
import enums.Material;

public class PenValidationRules 
{
	public static Color parseAndCheckColor(String color) throws IllegalArgumentException
	{
		return Color.valueOf(color.toUpperCase());
	}
	
	public static Brand praseAndCheckBrand(String brand) throws IllegalArgumentException
	{
		return Brand.valueOf(brand.toUpperCase());
	}
	
	public static LocalDate parseAndCheckDate(String date) throws IllegalArgumentException
	{
		return LocalDate.parse(date);
	}
	
	public static Material parseAndCheckMaterial(String material) throws IllegalArgumentException
	{
		return Material.valueOf(material.toUpperCase());
	}
	
	public static Pen validateAll(String color, String material, String brand, String stockUpdateDate, int price,int stock)
	{
		Brand newBrand = praseAndCheckBrand(brand);
		Color newColor = parseAndCheckColor(color);
		LocalDate newDate = parseAndCheckDate(stockUpdateDate);
		Material newMaterial = parseAndCheckMaterial(material);
		
		return new Pen(newColor,newMaterial,newBrand,newDate,price,stock);
		
	}
}
