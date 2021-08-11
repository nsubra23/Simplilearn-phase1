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
		System.out.println("enter the filename");
		String fileName=obj.next();
		deleteFile(FOLDER_PATH, fileName);
		
		
	//	saveFile(obj,FOLDER_PATH);
		
	//	getAllFiles(FOLDER_PATH);
		
	}
	
	public static void getAllFiles(String path) {
		List<String> fileNames=FileUtil.listAllFiles(FOLDER_PATH);
		if(fileNames!=null && !fileNames.isEmpty())
			fileNames.forEach(elt->System.out.println(elt));
		else
			System.out.println("Folder is empty");
	}
	
	public static void saveFile(Scanner obj,String FOLDER_PATH) {
		System.out.println("Enter the filename");
		String fileName=obj.next();
		System.out.println("Enter the number of lines");
		int line_count=obj.nextInt();
		List<String> lines=new ArrayList<String>();
		for(int i=0;i<line_count;i++) {
			System.out.println("Enter the line");
			String line=obj.next();
			lines.add(line);
			
		}
		boolean isAdded=FileUtil.addFile(FOLDER_PATH, fileName, lines);
		if(isAdded)
			System.out.println("File and Data saved successfully");
		else
			System.out.println("some error has occured.Please contact system administrator");
		
	}
	public static void deleteFile(String FOLDER_PATH, String fileName) {
		boolean isDeleted=FileUtil.deleteFile(FOLDER_PATH, fileName);
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("some error has occured.Please contact system administrator");
		
	}

}
