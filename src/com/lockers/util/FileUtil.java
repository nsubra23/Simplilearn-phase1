package com.lockers.util;

import java.io.File;
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
	 * 
	 * @param path
	 * @param filename
	 * @param content
	 * @return
	 */
	public boolean addFile(String path, String filename, List<String> content) {
		return true;
	}

}
