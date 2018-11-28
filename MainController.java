package application;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;

public class MainController {
	//private variables 
	
	//declare label, textfields and scanner
	@FXML
	private Label lblStatus;
	
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txPassword;
	
	private Scanner scanner;
	
	/**
	 * Function to be called when the button in UI is clicked
	 * Performs the interaction with user if the user login is success. 
	 * @param event
	 * @throws FileNotFoundException
	 */
	public void Login(ActionEvent event) throws FileNotFoundException {
		//check if the text entered in user and password fields match the preset ones
		if (txtUserName.getText().equals("user") && txPassword.getText().equals("pass")) {
			//if it does, set the text in status to login success
			lblStatus.setText("Login Success.");
			
		} else {
			//otherwise set it to login failed
			lblStatus.setText("Login Failed");
		}
		//if the text in status is login success
		if (lblStatus.getText().equals("Login Success.")) {
			//tell the user the the program is running
			System.out.println("The program is now running.");
			//declare a new scanner
			scanner = new Scanner(System.in);
			//make a action object
			actions act = new actions();
			//call the userInfo function and store the return value to user u
			user u = act.userInfo();
			//print the instructions
			System.out.println("Please select a service");
			System.out.println("1. Know yourself");
			System.out.println("2. Do sports");
			System.out.println("3. Have food");
			System.out.println("4. Quit");
			//read in a new user input as int choice
			int choice = scanner.nextInt();
			//when choice is not 4, do the following
			while (choice != 4) {
				//if choice is 1
				if (choice == 1) {
					//perform inquiries function
					act.inquiries(u);
					//print out the instructions again
					System.out.println("Please select a service");
					System.out.println("1. Know yourself");
					System.out.println("2. Do sports");
					System.out.println("3. Have food");
					System.out.println("4. Quit");
					//get user input again
					choice = scanner.nextInt();
					//if choice is 2
				} else if (choice == 2) {
					//perform the sports function
					act.doSomeSports();
					//print the instructions again
					System.out.println("Please select a service");
					System.out.println("1. Know yourself");
					System.out.println("2. Do sports");
					System.out.println("3. Have food");
					System.out.println("4. Quit");
					//read in the user input again
					choice = scanner.nextInt();
					//if choice is 3
				} else if (choice == 3) {
					//perform the eat food function
					act.eatFood();
					//print the instructions
					System.out.println("Please select a service");
					System.out.println("1. Know yourself");
					System.out.println("2. Do sports");
					System.out.println("3. Have food");
					System.out.println("4. Quit");
					//get user input again
					choice = scanner.nextInt();
					//otherwise tell the user the input is invalid and get input again
				} else {
					System.out.println("Please enter a valid number.");
					choice = scanner.nextInt();
				}
			}
			//tell the user the program ended when while loop is done
			System.out.println("The program is ended.");
			//close the scanner
			scanner.close();
		}
	}
}
