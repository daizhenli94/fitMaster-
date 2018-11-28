package application;

import java.io.FileNotFoundException;
import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class actions extends Application {
	
	//declare a scanner variable
	private static Scanner scanner;
	
	//methods 
	
	/**
	 * Ask the user to input their info and store in a user class
	 * @return user
	 */
	public user userInfo() {
		//declare a scanner
		scanner = new Scanner(System.in);
		//prompt for user to enter their name
		System.out.println("Enter your name:	");  
		//get the name 
		String name = scanner.nextLine();
		//ask the user for their age
		System.out.println("Enter your age:	");
		//read in the age
		int age = scanner.nextInt();
		//ask the user for their weight
		System.out.println("Enter your weight:	");
		//read in the weight as a double
		double weight = scanner.nextDouble();
		//ask the user for their height
		System.out.println("Enter your height:	");
		//read in the height as a double
		double height = scanner.nextDouble();
		//ask the user for their gender
		System.out.println("Enter your gender:	");
		//skip the excess line
		scanner.nextLine();
		//read in the gender as a string
		String gender = scanner.nextLine();
		//create an object user, and assign the values into it
		user u = new user(name, age, weight, height, gender);
		return u;
	}
	
	/**
	 * print out instructions for user choices 
	 */
	public void printInstructions() {
		//print instructions for the user the follow
		System.out.println("Here are the things you can know about yourself:	");  
		System.out.println("1. Your BMR	"); 
		System.out.println("2. Your BMI	");    
		System.out.println("3. Your body condition	"); 
		System.out.println("4. Your body fat	");
		System.out.println("5. Your calorie needs	");
		System.out.println("6. Done with the inquiries. ");
		System.out.println("Please enter the number of choice:	");
	}
	
	/**
	 * Let the user make inquiries about their health
	 * @param u
	 */
	public void inquiries(user u) {
		//print instructions
		this.printInstructions();
		//read in an int choice
		int choice = scanner.nextInt();
		//perform different functions base on user choice, if choice equals 6, quit the while loop
		while (choice != 6) {
			//if choice is 1, calculate and print bmr
			if (choice == 1) {
				double bmr = u.calculateBMR();
				//print bmr and the instructions again
				System.out.println(bmr);
				this.printInstructions();
				//read in another user input and do the while loop again
				choice = scanner.nextInt();
				//if choice equals 2, caculate bmi
			} else if (choice == 2) {
				double bmi = u.calculateBMI();
				//print bmi and instructions
				System.out.println(bmi);
				this.printInstructions();
				//read in another user input
				choice = scanner.nextInt();
				//if choice equals 3, calcualte body condition
			} else if (choice == 3) {
				String bodyCondition = u.getBodyCondition();
				//print body condition and instructions again
				System.out.println(bodyCondition);
				this.printInstructions();
				//get user choice again
				choice = scanner.nextInt();
				//if choice is 4
			} else if (choice == 4) {
				//ask user for another input 
				System.out.println("Are you a child or an adult, please enter 'child'"
						+ "or 'adult' with no capital letters	");
				//read in the input
				scanner.nextLine();
				String lifeStage = scanner.nextLine();
				//calculate body fat base on the recent input
				double bodyFat = u.getBodyFat(lifeStage);
				//print the body fat and instructions again
				System.out.println(bodyFat);
				this.printInstructions();
				//read in another user input
				choice = scanner.nextInt();
				//if choice is 5
			} else if (choice == 5) {
				//ask for another user input
				System.out.println("Are you sedentary, moderately active, or active? Please enter as"
						+ "one of the three choices");
				//read in the user input
				scanner.nextLine();
				String energyFactor = scanner.nextLine();
				//calculate calorie need base on the new input
				double caloricNeed = u.calculateCaloricNeed(energyFactor);
				//print out the result and instructions again
				System.out.println(caloricNeed);
				this.printInstructions();
				//read in another input
				choice = scanner.nextInt();
				//if choice equals any other values
			} else {
				//ask for a valid input and print the instructions again
				System.out.println("Please enter a valid number.");
				this.printInstructions();
				//scan in the next input
				choice = scanner.nextInt();
			}
		}
		System.out.println("The inquiry is done.");
		return;
	}
	
	/**
	 * Let the user perform functions in the sports section
	 */
	public void doSomeSports() {
		//create a new sports sport
		sports sport = new sports();
		//print instructions, ask for a user input
		System.out.println("What do you want to know?");
		System.out.println("1. The calories I've burnt");
		System.out.println("2. How long do I need to do this sport");
		//read in the user input as choice
		int choice = scanner.nextInt();
		//if choice is 1, perform the calculateCalorie function
		if (choice == 1) {
			//ask for a sport choice
			System.out.println("What is the sport that you did? (Capital first letter)");
			//read it in
			scanner.nextLine();
			String sportsChoice = scanner.nextLine();
			//ask for a time length value
			System.out.println("And for how long? (Enter a number in min)");
			//read in the time
			double time = scanner.nextDouble();
			//calculate calories burnt
			double calories = sport.calculateCalorie(sportsChoice, time);
			//print it out
			System.out.println("Your calories burnt is: " + calories);
			//if choice equals 2, perform the calculateSportsTime function
		} else if (choice == 2) {
			//ask for a sport choice
			System.out.println("What is the sport that you want to do? (Capital first letter)");
			//read it in
			scanner.nextLine();
			String sportsChoice = scanner.nextLine();
			//ask for a calorie value
			System.out.println("And how many calories do you want to burn? (Enter a number in min)");
			//read in it
			double calorieGoal = scanner.nextDouble();
			//calculate the time needed
			double time = sport.calculateSportTime(sportsChoice, calorieGoal);
			//print out the calculated info
			System.out.println("You may want to do" + sportsChoice + "for: " + time + " minutes");
			//for all other choices
		} else {
			//ask for a valid input
			System.out.println("Please enter a valid number.");
			//read in user input again
			choice = scanner.nextInt();
		}
	}
	
	/**
	 * This function will let the user use functions from the food section
	 * @throws FileNotFoundException
	 */
	public void eatFood() throws FileNotFoundException {
		//create a food 
		food theFood = new food();
		//tell the user to enter a food name
		System.out.println("Please enter the food you had.");
		//scan it in
		scanner.nextLine();
		String foodChoice = scanner.nextLine();
		//ask the user to enter the amount
		System.out.println("And please enter the amount.");
		//read it in
		double amount = scanner.nextDouble();
		//calculate the calorie intakes 
		double calories = theFood.calculateCalorie(foodChoice, amount);
		//print out the result
		System.out.println("The calories you have consumed is " + calories);
	}
	
	/**
	 * Function to initiate the user interface, will be directed to MainController upon clicking 
	 * the button
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			//set a parent root to login.fxml
			Parent root = FXMLLoader.load(getClass().getResource("/application/LogIn.fxml"));
			//set the scene size
			Scene scene = new Scene(root,400,400);
			//get style info from application.css
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//show the primary stage
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method to be called, initiates the 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//initiate the user interface
		launch(args);
	}

}
