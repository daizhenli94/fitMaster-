package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class userTest {

	@Test
	public void testUser() {
		user testUser = new user("Daizhen",23,75,177,"male");
		assertEquals("gender is male",testUser.gender,"male");
	}
	
	@Test
	public void testUserAge() {
		user testUser = new user("Daizhen",23,75,177,"male");
		assertEquals("age is 23",testUser.age,23);
	}
	
	@Test
	public void testUserHeight() {
		user testUser = new user("Daizhen",23,75,177,"male");
		assertEquals("height is 177",testUser.height,177,0.00001);
	}
	
	@Test
	public void testCalculateBMR() {
		user testUser = new user("Daizhen",23,75,177,"male");
		double bmr = testUser.calculateBMR();
		assertEquals("BMR is 1822.1",bmr,1822.1,0.00001);
	}
	
	@Test
	public void testCalculateBMRAllZero() {
		user testUser = new user("Daizhen",0,0,0,"male");
		double bmr = testUser.calculateBMR();
		assertEquals("BMR is 66",bmr,66,0.00001);
	}
	
	@Test
	public void testCalculateBMRUnusualGender() {
		user testUser = new user("Daizhen",0,0,0,"banana");
		double bmr = testUser.calculateBMR();
		assertEquals("BMR is 0 by default",bmr,0.0,0.00001);
	}
	
	@Test
	public void testCalculateBMI() {
		user testUser = new user("Daizhen",23,75,177,"male");
		double bmi = testUser.calculateBMI();
		assertEquals("BMI is 23.9",bmi,23.939,0.001);
	}
	
	@Test
	public void testCalculateBMIZeroWeight() {
		user testUser = new user("Daizhen",23,0,177,"male");
		double bmi = testUser.calculateBMI();
		assertEquals("BMI is 0",bmi,0.0,0.001);
	}
	
	@Test
	public void testCalculateBMIDecimal() {
		user testUser = new user("Daizhen",23,7.5,177,"male");
		double bmi = testUser.calculateBMI();
		assertEquals("BMI is 2.39",bmi,2.394,0.001);
	}
	
	@Test
	public void testGetBodyCondition() {
		user testUser = new user("Daizhen",23,75,177,"male");
		String bodyType = testUser.getBodyCondition();
		assertEquals("Result should be overweight",bodyType,"Overweight");
	}
	
	@Test
	public void testGetBodyConditionZeroWeight() {
		user testUser = new user("Daizhen",23,0,177,"male");
		String bodyType = testUser.getBodyCondition();
		assertEquals("Result should be Severe Thinness",bodyType,"Severe Thinness");
	}
	
	
	@Test
	public void testGetBodyFat() {
		user testUser = new user("Daizhen",23,75,177,"male");
		double bodyFat = testUser.getBodyFat("adult");
		assertEquals("Body fat should be 17.81",bodyFat,17.81,0001);
	}
	
	@Test
	public void testGetBodyFatVeryLowWeight() {
		user testUser = new user("Daizhen",23,7.5,177,"male");
		double bodyFat = testUser.getBodyFat("adult");
		assertEquals("Body fat should be 0 instead of negative value"
				+ "if weight too low",bodyFat,0.0,0001);
	}
	
	@Test
	public void testGetBodyFatFemale() {
		user testUser = new user("Daizhen",23,75,177,"female");
		double bodyFat = testUser.getBodyFat("adult");
		assertEquals("Body fat should be 28.617",bodyFat,28.617,0001);
	}
	
	@Test
	public void testGetBodyFatChild() {
		user testUser = new user("Daizhen",23,75,177,"female");
		double bodyFat = testUser.getBodyFat("child");
		assertEquals("Body fat should be 21.448",bodyFat,21.448,0001);
	}
	
	@Test
	public void testCalculateCaloricNeedInvalidInput() {
		user testUser = new user("Daizhen",23,7.5,177,"male");
		double physicalActivityFactor = testUser.calculateCaloricNeed("Super");
		assertEquals("PAF is 0 in this case",physicalActivityFactor,
				0.0,0.001);
	}
	
	@Test
	public void testCalculateCaloricNeedCheckEnergyLevel() {
		user testUser = new user("Daizhen",23,75,177,"male");
		double physicalActivityFactor = 
				testUser.calculateCaloricNeed("sedentary");
		assertEquals("PAF is 2196.12 in this case",physicalActivityFactor,
				2196.12,0.001);
	}
	
	@Test
	public void testCalculateCaloricNeedFemale() {
		user testUser = new user("Daizhen",23,75,177,"female");
		double physicalActivityFactor = 
				testUser.calculateCaloricNeed("sedentary");
		assertEquals("PAF is 1923.96 in this case",physicalActivityFactor,
				1923.96,0.001);
	}
}
