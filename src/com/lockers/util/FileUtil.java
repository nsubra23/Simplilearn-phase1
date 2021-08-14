package com.lockers.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtil {
	/**
	 * This method will return the file names from the folder in ascending order
	 * 
	 * @param path
	 * @return List<String>
	 */
	public static List<String> listAllFiles(String path) {
		//creating file object
		File folder = new File(path);
		
		//Declare the list to store file names
		List<String> fileNamesList = null;
		
		// checking it is a folder or not
		if (folder.isDirectory()) {
			
			// Getting all files into Array
			File[] files = folder.listFiles();
			
			if (files.length > 0) {
				fileNamesList = new ArrayList<String>();
				
				// Looping files and add file names to list
				for (File file : files) {
					fileNamesList.add(file.getName());
				}
				
				// sort filenames
				Collections.sort(fileNamesList);
			}

		}

		return fileNamesList;
	}

	/**
	 * This method will read input like filepath, file name and content from user
	 * and it will add that content by creating a new file
	 * 
	 * @param path
	 * @param filename
	 * @param content
	 * @return boolean
	 */
	public static boolean addFile(String path, String filename, List<String> content) {
		//Creating Filewriter object
		try(FileWriter writer= new FileWriter(path+File.separator+filename); )
		{
			//Looping content to write into file
			for(String text:content) {
				writer.write(text+"\n");
			}
				
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This method will delete the user specified if exists
	 * 
	 * @param path
	 * @param filename
	 * @return boolean
	 */
	public static boolean deleteFile(String path, String filename) {
		boolean flag=false;
		
		//creating file object
		File file=new File(path+File.separator+filename);
		
		//check whether file exists or not and also ensure case sensitivity search on file name
		 if(fileExistsCaseSensitive(file)) {
			 flag=file.delete();
			 
		 }
		return flag;
		
	}
	/**
	 * This method will return true if user specified exists else it return false
	 * @param path
	 * @param filename
	 * @return boolean
	 */
	public static boolean searchForFile(String path, String filename) {
		//creating file object
		File file=new File(path+File.separator+filename);
		
		//check whether file exists ,also ensure case sensitivity search on file name and return true if exists
		return fileExistsCaseSensitive(file);
		
	}
	
	/**
	 * This method will ensure case sensitivity on file name and return true if matches
	 * @param file
	 * @return boolean
	 */
	public static boolean fileExistsCaseSensitive(File file) {
	    try {
	    	//check whether file exists and also ensure case sensitivity search on file name and return true if exists
	        return file.exists() && file.getCanonicalFile().getName().equals(file.getName());
	    } catch (IOException e) {
	        return false;
	    }
	}
}
