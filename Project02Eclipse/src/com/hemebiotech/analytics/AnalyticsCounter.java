package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		if (symptoms == null || symptoms.isEmpty()) {
		    throw new IllegalArgumentException("The symptoms list cannot be null or empty");
		}
		
		Map<String, Integer> symptomOccurrences = new HashMap<>();
		
		for (String symptom : symptoms) {
			if (!symptomOccurrences.containsKey(symptom)) {
				symptomOccurrences.put(symptom, 1);
			} else {
				symptomOccurrences.replace(symptom, symptomOccurrences.get(symptom)+1);
			} 
		}

		return symptomOccurrences;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms; 
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
