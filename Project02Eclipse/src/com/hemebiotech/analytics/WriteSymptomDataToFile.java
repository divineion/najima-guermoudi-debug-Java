package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private static Logger logger = LogManager.getLogger(WriteSymptomDataToFile.class);
	
	/**
	 * This method iterates over a provided Map of symptoms with their occurrences,
	 *  and writes each entry in a text file named "result.out".
	 * 
	 * @param symptoms : a Map where symptoms (String) are keys and occurrences (Integer) are values.
	 * 	Each entry will be written on a new line.
	 * 
	 * @throws IOException if an I/O error occurs while writing to the file. 
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		
		if (symptoms.isEmpty() ) {
			logger.info("The data is empty.");
			
			return;
		}
		
		try (FileWriter writer = new FileWriter ("result.out")) {
			for (Entry<String, Integer> symptomOccurrence : symptoms.entrySet()) {
			writer.write(symptomOccurrence.getKey() + " : " + symptomOccurrence.getValue() + "\n");
			}
			
			logger.info("The output data has been successfully written to the file 'result.out'.");
			
		} catch(IOException e) {
			logger.error(e.getMessage());
		}
	}
}
