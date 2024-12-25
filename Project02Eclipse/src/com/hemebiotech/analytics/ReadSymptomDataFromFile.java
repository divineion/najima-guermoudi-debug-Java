package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hemebiotech.analytics.constants.ErrorMessages;
import com.hemebiotech.analytics.constants.InfoMessages;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	private static Logger logger = LogManager.getLogger(ReadSymptomDataFromFile.class);

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * This method reads the provided text file line by line and adds each line to
	 * an ArrayList "result".
	 * 
	 * @return result, the array containing all symptoms, including possible
	 *         duplicates.
	 * @throws FileNotFoundException if an attempt to open the file denoted by a
	 *                               specified pathname has failed, IOException if
	 *                               any I/O exception occurs.
	 */
	
	@Override
	public List<String> getSymptoms() throws IOException {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				logger.info(InfoMessages.FILE_READ_ATTEMPT, filepath);
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

				reader.close();

			} catch (FileNotFoundException e) {
				logger.error(ErrorMessages.FILE_NOT_FOUND, filepath);

			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

		return result;
	}
}
