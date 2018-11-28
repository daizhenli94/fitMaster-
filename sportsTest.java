package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class sportsTest {

	@Test
	public void testSports() {
		sports testSports = new sports();
		int calories = testSports.sportsIndex.get("Archery");
		assertEquals("The calories burnt by 15min of Archery is 43.",
				calories, 43);
		assertEquals("The calories burnt by 15min of Billiards is 26.",
				(int) testSports.sportsIndex.get("Billiards"), 26);
		assertEquals("The calories burnt by 15min of Fencing is 85.",
				(int) testSports.sportsIndex.get("Fencing"), 85);
	}
	
	@Test
	public void testCalculateCalories() {
		sports testSports = new sports();
		double caloriesBurnt = testSports.calculateCalorie("Soccer",30);
		assertEquals("The calories burnt should be 306",
				caloriesBurnt,306,0.00001);
	}
	
	@Test
	public void testCalculateCaloriesDecimal() {
		sports testSports = new sports();
		double caloriesBurnt = testSports.calculateCalorie("Soccer",31);
		assertEquals("The calories burnt should be 316.2",
				caloriesBurnt,316.2,0.00001);
	}
	
	@Test
	public void testCalculateCaloriesZeroTime() {
		sports testSports = new sports();
		double caloriesBurnt = testSports.calculateCalorie("Soccer",0);
		assertEquals("The calories burnt should be 0",
				caloriesBurnt,0.0,0.00001);
	}
	
	@Test
	public void testCalculateSportTime() {
		sports testSports = new sports();
		double time = testSports.calculateSportTime("Soccer",153);
		assertEquals("The time required should be 15",
				time,15,0.00001);
	}
	
	@Test
	public void testCalculateSportTimeZeroCalorie() {
		sports testSports = new sports();
		double time = testSports.calculateSportTime("Soccer",0);
		assertEquals("The time required should be 0",
				time,0.0,0.00001);
	}
	
	@Test
	public void testCalculateSportTimeDecimal() {
		sports testSports = new sports();
		double time = testSports.calculateSportTime("Soccer",15.3);
		assertEquals("The time required should be 1.5",
				time,1.5,0.00001);
	}
}
