package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptoms data into a file
 */
public interface ISymptomWriter {
	/**
	 * Writes symptoms and their occurs in a text file
	 * 
	 * @param symptoms : a Map of symptom and theirs occurs, alphabetically sorted
	 */
	void writeSymptoms(Map<String, Integer> symptoms);
}
