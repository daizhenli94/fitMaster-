package application;

import java.io.*;
import java.util.*;
 
public class fileInput {
 
    private static Scanner scanner;

    /**
     * Reads in info from file for both food and sports
     * @param dataFile
     * @param inputFood
     * @throws FileNotFoundException
     */
	public static void readInfo(File dataFile, 
			HashMap<String, Integer> inputHashMap) throws FileNotFoundException{
        try {
			scanner = new Scanner(dataFile);
			while(scanner.hasNextLine()) {
			    String stringData = scanner.nextLine();
			    String[] info = stringData.split(",");
			    inputHashMap.put(info[0], 
			    		Integer.parseInt(info[1]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("The given file is invalid");
			// //e.getMessage() - gets the error message. no info about which line.
			e.printStackTrace();
		}
        scanner.close();
	}
}
 