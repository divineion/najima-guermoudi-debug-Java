package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * Main class for the symptom analytics application.
 * This class initializes the reading, counting, sorting, and writing processes for symptom data.
 * 
 * <p>The application reads symptoms from a file, counts their occurrences, sorts them alphabetically,
 * and writes the results to an output file.</p>
 * 
 * <p>Steps : </p>
 * <ol>
 *   <li>Read symptoms from an input file using {@link ReadSymptomDataFromFile}.</li>
 *   <li>Count the occurrences of each symptom using {@link AnalyticsCounter}.</li>
 *   <li>Sort the symptoms alphabetically.</li>
 *   <li>Write the sorted symptoms and their occurrences to an output file using {@link WriteSymptomDataToFile}.</li>
 * </ol>
 * 
 * <p>Expected file structure: One symptom per line in the input file.</p>
 */
public class Main {
	 /**
     * Entry point of the application. Initiates the reading, processing, and writing of symptom data.
     *
     * @param args Command-line arguments (not used in this implementation).
	 * @throws IOException 
     */
	public static void main(String[] args) {
		
		String filePath = "symptoms.txt";
		
		try {
		ISymptomReader reader = new ReadSymptomDataFromFile(filePath);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		List<String> symptoms = reader.getSymptoms();
		Map<String, Integer> symptomOccurrences = counter.countSymptoms(symptoms);
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomOccurrences);
		
		writer.writeSymptoms(sortedSymptoms);
		
		} catch (FileNotFoundException e) {
			// @Todo write message in file
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
