package com.lockers;

import java.util.List;
import java.util.Scanner;

import com.lockers.util.FileUtil;

public class LockedMeApp {
	//Global variable declaration
	public static final String FOLDER_PATH="C:\\Projects\\Simplilearn\\Phase1\\LockedMeFiles\\";
	
	public static void main(String[] args) {
		
		getAllFiles(FOLDER_PATH);
		
	}
	
	public static void getAllFiles(String path) {
		List<String> fileNames=FileUtil.listAllFiles(FOLDER_PATH);
		if(fileNames!=null && !fileNames.isEmpty())
			fileNames.forEach(elt->System.out.println(elt));
		else
			System.out.println("Folder is empty");
	}

}
