package application;

import java.io.*;
import java.util.*;

public class food {
	//instance variable, set a hashmap
	public HashMap<String, Integer> foodIndex;
	
	/**
	 * food constructor, loads food and its caloric value into the foodIndex
	 * @throws FileNotFoundException
	 */
	public food() throws FileNotFoundException {
		//declare a hashmap
		foodIndex = new HashMap<String, Integer>();
		//read in from data file and store into hashmap
		try {
			//file path is specified
			File dataFile = new File
					("/Users/Ticktock/Desktop/cit590/HW9/foodCalories.csv");
			//read in the data 
			fileInput.readInfo(dataFile, foodIndex);
			//if file not exist, output an error
		} catch (FileNotFoundException e) {
			//print message when there is an errr
			System.out.println("The given file is invalid");
			// //e.getMessage() - gets the error message. no info about which line.
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculate the actual caloric value base on the amount consumed
	 * @param foodChoice
	 * @param amount
	 * @return calories
	 */
	public double calculateCalorie(String foodChoice, double amount) {
		//return the calculated calories
		return (double) this.foodIndex.get(foodChoice) / 100 * amount;
	}
}
