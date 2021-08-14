package com.lockers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lockers.util.FileUtil;

public class LockedMeApp {
	//Global variable declaration
	public static final String FOLDER_PATH="C:\\Projects\\Simplilearn\\Phase1\\LockedMeFiles\\";
	
	public static void main(String[] args) {
		
		Scanner obj=new Scanner(System.in);
		
		System.out.println("*******************************************************************************************");
		System.out.println("\t\t LockedMe.com");
		System.out.println("*******************************************************************************************");
		System.out.println("1. List All Files");
		System.out.println("2. Add File");
		System.out.println("3. Delete File");
		System.out.println("4. Search File");
		System.out.println("*******************************************************************************************");
		System.out.println("Enter your choice");
		int choice=obj.nextInt();
		
		switch(choice) {
			case 1: getAllFiles(FOLDER_PATH);
						break;
			case 2: 
				saveFile(obj,FOLDER_PATH);
						break;
			
			case 3: 
				System.out.println("Enter the filename");
				String fileName=obj.next();
				deleteFile(FOLDER_PATH,fileName);
						break;
			
			case 4: 
				System.out.println("enter the filename");
				String fleName=obj.next();
				searchFile(FOLDER_PATH,fleName);
						break;
			default:
				System.exit(0);
		}
		
	}
	/**
	 * This method will retrieve all file names in the directory
	 * @param path
	 */
	public static void getAllFiles(String path) {
		//Retrieve all file names from the directory
		List<String> fileNames=FileUtil.listAllFiles(FOLDER_PATH);
		
		//If list is not empty and null , print the file name
		if(fileNames!=null && !fileNames.isEmpty())
			fileNames.forEach(elt->System.out.println(elt));
		else
			System.out.println("Folder is empty");
	}
	
	/**
	 * This method will save the content to a file by creating a new file
	 * @param obj
	 * @param FOLDER_PATH
	 */
	public static void saveFile(Scanner obj,String FOLDER_PATH) {
		//Read file name from the user
		System.out.println("Enter the filename");
		String fileName=obj.next();
		
		//Read the number of lines from the user
		System.out.println("Enter the number of lines");
		int line_count=obj.nextInt();
		
		//Read the lines from the user
		List<String> lines=new ArrayList<String>();
		for(int i=0;i<line_count;i++) {
			System.out.println("Enter the line "+i);
			String line=obj.next();
			lines.add(line);
			
		}
		
		//Return true if content got saved to file sucessfully
		boolean isAdded=FileUtil.addFile(FOLDER_PATH, fileName, lines);
		if(isAdded)
			System.out.println("File and Data saved successfully");
		else
			System.out.println("some error has occured.Please contact system administrator");
		
	}
	/**
	 * This method will delete the specified file
	 * @param FOLDER_PATH
	 * @param fileName
	 */
	public static void deleteFile(String FOLDER_PATH, String fileName) {
		
		//Delete the user specified file if exists and return true if success
		boolean isDeleted=FileUtil.deleteFile(FOLDER_PATH, fileName);
		
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("File may not exists");
		
	}
	/**
	 * This method will search for user specified file
	 * @param FOLDER_PATH
	 * @param fileName
	 */
	public static void searchFile(String FOLDER_PATH, String fileName) {
		
		//Return true if the user specified file exists else return false
		boolean isFound=FileUtil.searchForFile(FOLDER_PATH, fileName);
		
		if(isFound)
			System.out.println("File is found");
		else
			System.out.println("File is not there.Please contact system administrator");
		
	}

}
