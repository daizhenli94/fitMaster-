package application;

public class user {
	//instance variables
	public String name;
	public int age;
	public double weight;
	public double height;
	public String gender;
	
	//methods
	
	/**
	 * Constructor, assign values to name, age, weight, height and gender
	 * @param name
	 * @param age
	 * @param weight
	 * @param height
	 * @param gender
	 */
	public user(String name, int age, double weight, double height,
			String gender) {
		//assign the variables to the user 
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gender = gender;
	}
	
	/**
	 * This method calculates the basal metabolic rate
	 * @return bmr
	 */
	public double calculateBMR() {
		//declare a double 
		double bmr;
		//calculate bmr base on gender, ie. "male" or "female"
		if (this.gender.equals("female")) {
			bmr = 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
		} else if (this.gender.equals("male")) {
			bmr = 66 + 13.7 * weight + 5 * height - 6.8 * age;
		} else {
			//handle other cases when gender is not known
			System.out.println("Gender info can't be resolved");
			//set bmr to zero
			bmr = 0;
		}
		return bmr;
	}
	
	/**
	 * This method calculates BMI using metric formulas
	 * @return bmi
	 */
	public double calculateBMI() throws ArithmeticException {
		//declare and calculate bmi
		double bmi = 0;
		bmi = weight / Math.pow((height / 100),2);
		return bmi;
	}
	
	/**
	 * Gives the body conditions based on BMI
	 * @return bodyCondition
	 */
	public String getBodyCondition() {
		//get the bmi value from calculateBMI function
		double bmi = this.calculateBMI();
		//define body type base on the calculated bmi value
		if (bmi < 16) {
			return "Severe Thinness";
		} else if (16 >= bmi && bmi < 17) {
			return "Moderate Thiness";
		} else if (17 >= bmi && bmi < 18.5) {
			return "Mild Thinness";
		} else if (18.5 >= bmi && bmi < 25) {
			return "Normal";
		} else if (25 >= bmi && bmi < 30) {
			return "Overweight";
		} else if (bmi >= 30 && bmi < 35) {
			return "Obese Class I";
		} else if (bmi >= 35 && bmi < 40) {
			return "Obese Clasee II";
		} else {
			return "Obese Class III";
		}
	}
	
	/**
	 * calculates body fat using bmi method
	 * @return bodyFat
	 */
	public double getBodyFat(String lifeStage) {
		//declare a double bodyFat and am int sex
		double bodyFat = 0;
		int sex;
		//get the bmi value from calculateBMI function
		double bmi = this.calculateBMI();
		//set sex value base on gender, if female, sex = 0, otherwise sex = 1
		if (gender.equals("female")) {
			sex = 0;
		} else {
			sex = 1;
		}
		//declare a variable to determine if while loop should be terminated
		boolean running = true;
		//while loop for calculating body fat
		while (running)
			//if the life stage is child, or if it's adult, calculate body fat  
			if (lifeStage.equalsIgnoreCase("child")) {
				bodyFat = 1.51 * bmi - 0.7 * age - 3.6 * sex + 1.4;
				running = false;
			} else if(lifeStage.equalsIgnoreCase("Adult")) {
				bodyFat = 1.20 * bmi + 0.23 * age - 10.8 * sex - 5.4;
				running = false;
			//otherwise, ask the user to input the life stage again
			} else {
				System.out.println("Please enter a valid input.");
			}
		//if the bodyfat is calculated to be negative, set it to zero
		if (bodyFat < 0) {
			bodyFat = 0;
		}
		return bodyFat;
	}
	
	/**
	 * Calculate calorie need using Harris-Benedic Equation
	 * @return caloricNeed
	 */
	public double calculateCaloricNeed(String energyFactor) {
		//declare a variable to store the physical activity factor 
		double physicalActivityFactor;
		//set physical activity factor differently base on different input energy factors
		if (energyFactor.equals("sedentary")) {
			physicalActivityFactor = 1.2;
		} else if (energyFactor.equals("moderately active")) {
			physicalActivityFactor = 1.3;
		} else if (energyFactor.equals("active")) {
			physicalActivityFactor = 1.4;
		} else {
			//tell the user that the input is not valid and return zero
			System.out.println("Please enter a valid energy factor");
			return 0.0;
		}
		//calculate calorie need base on different genders. 
		if (gender.equals("male")) {
			return physicalActivityFactor * (66.5 + 13.8 * weight + 5 * height - 6.8 * age);
		} else {
			return physicalActivityFactor * (655.1 + 9.6 * weight + 1.9 * height - 4.7 * age);
		}
	}
}

