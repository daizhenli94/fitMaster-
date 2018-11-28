package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class sports {
	public HashMap<String, Integer> sportsIndex;
	
	/**
	 * Constructor, reads from sports data file and put data into sportsIndex
	 */
	public sports() {
		//declare a hashmap
		sportsIndex = new HashMap<String, Integer>();
		try {
			//get a new file and specify the file path
			File dataFile = new File
					("/Users/Ticktock/Desktop/cit590/HW9/sportsCalories.csv");
			//read in from data file and store the values into hashmap
			fileInput.readInfo(dataFile, sportsIndex);
			//if file not exist, print out message and throw an error
		} catch (FileNotFoundException e) {
			System.out.println("The given file is invalid");
			// //e.getMessage() - gets the error message. no info about which line.
			e.printStackTrace();
		}
	}
	
	/**
	 * Calculate the amount of calories burnt for doing a sport 
	 * for a given amount of time
	 * @param sportsChoice
	 * @param time
	 * @return caloriesBurnt
	 */
	public double calculateCalorie(String sportsChoice, double time) {
		//return the calculated calorie value
		return (double) this.sportsIndex.get(sportsChoice) / 15 * time;
	}
	
	/**
	 * Calculate the time one need to burn a given amount of calories with 
	 * the sport of choice
	 * @param sportsChoice
	 * @param calorieGoal
	 * @return time
	 */
	public double calculateSportTime(String sportsChoice, double calorieGoal) {
		//return the calculated time
		return calorieGoal / (double) this.sportsIndex.get(sportsChoice) * 15;
	}
}
