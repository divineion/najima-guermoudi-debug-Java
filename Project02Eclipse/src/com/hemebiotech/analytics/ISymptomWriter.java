package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptoms data into a file
 */
public interface ISymptomWriter {
	/**
	 * Writes symptoms and their occurs in a text file
	 * 
	 * @param symptoms : a {@link Map} of symptom and theirs occurs, alphabetically sorted
	 * @throws IOException 
	 */
	void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
