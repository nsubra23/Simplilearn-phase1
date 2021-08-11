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
		File folder = new File(path);
		List<String> fileNamesList = null;
		// checking it is a folder or not
		if (folder.isDirectory()) {
			// Pull all files from the path
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
		try(FileWriter writer= new FileWriter(path+File.separator+filename); )
		{
			for(String text:content) {
				writer.write(text);
			}
				
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteFile(String path, String filename) {
		boolean flag=false;
		File file=new File(path+File.separator+filename);
		 if(fileExistsCaseSensitive(file)) {
			 flag=file.delete();
			 
		 }else {
			 System.out.println("File not exists");
		 }
		return flag;
		
	}
	public static boolean searchForFile(String path, String filename) {
		File file=new File(path+File.separator+filename);
		return fileExistsCaseSensitive(file);
		
	}
	
	public static boolean fileExistsCaseSensitive(File file) {
	    try {
	        return file.exists() && file.getCanonicalFile().getName().equals(file.getName());
	    } catch (IOException e) {
	        return false;
	    }
	}
}
