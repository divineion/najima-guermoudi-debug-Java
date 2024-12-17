package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * This class provides a method to process a provided symptoms list and return a sorted collection of unique symptoms with their frequency of occurrence.
 */
public class ProcessSymptomDataFromFile implements ISymptomProcessor {
	private List<String> symptomsList;
	
	public ProcessSymptomDataFromFile(List <String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	/**
	 * <p>
	 * Processes a list of symptoms and stores each symptom  with its occurrence count in a {@link TreeMap}:
	 * if a symptom is not already in the map, it is added with an initial count of 1. 
	 * Otherwise, the count for the existing symptom is incremented. 
	 * </p>
	 * 
	 *  @return a {@link TreeMap} containing: <br>
	 *  - keys: unique symptoms (String), sorted alphabetically.<br>
	 *  - values: the occurrence count for each symptom (Integer).
	 *  
	 *  @throws IllegalArgumentException if the provided list is null or empty.
	 */
	
	@Override
	public Map<String, Integer> processSymptomsList() {
		if (symptomsList == null || symptomsList.isEmpty()) {
		    throw new IllegalArgumentException("The symptoms list cannot be null or empty");
		}
		Map<String, Integer> symptomOccurrences = new TreeMap<>();
		for (String symptom : symptomsList) {
			if (!symptomOccurrences.containsKey(symptom)) {
				symptomOccurrences.put(symptom, 1);
			} else {
				symptomOccurrences.replace(symptom, symptomOccurrences.get(symptom)+1);
			} 
		}
		return symptomOccurrences;
	}
}
