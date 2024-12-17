package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will process a list of symptoms and provides a mapping of symptoms and their occurrences.
 * 
 */
public interface ISymptomProcessor {
	/**
	 * 
	 * @return a map containing symptoms with their occurrence counts.
	 */
	Map<String, Integer> processSymptomsList();
}
