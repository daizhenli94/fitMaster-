package application;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class foodTest {

	@Test
	public void testFood() throws FileNotFoundException {
		food testFood = new food();
		int calories = testFood.foodIndex.get("Hickory nut");
		assertEquals("The calories of 100g Hickory nut is 673.",
				calories, 673);
		assertEquals("The calories of 100g Peanut is 564.",
				(int) testFood.foodIndex.get("Peanut"), 564);
		assertEquals("The calories of 100g Vegetable oil is 884.",
				(int) testFood.foodIndex.get("Vegetable oils"), 884);
	}
	
	@Test
	public void testCalculateCalories() throws FileNotFoundException {
		food testFood = new food();
		double caloriesTaken = testFood.calculateCalorie("Wild rice",100);
		assertEquals("The calories taken should be 353",
				caloriesTaken,353,0.00001);
	}
	
	@Test
	public void testCalculateCaloriesZeroFood() throws FileNotFoundException {
		food testFood = new food();
		double caloriesTaken = testFood.calculateCalorie("Wild rice",0);
		assertEquals("The calories taken should be 0",
				caloriesTaken,0,0.00001);
	}
	
	@Test
	public void testCalculateCaloriesDecimal() throws FileNotFoundException {
		food testFood = new food();
		double caloriesTaken = testFood.calculateCalorie("Wild rice",0.1);
		assertEquals("The calories taken should be 0",
				caloriesTaken,0.353,0.00001);
	}
}