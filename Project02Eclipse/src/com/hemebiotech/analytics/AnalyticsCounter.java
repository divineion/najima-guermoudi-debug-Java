package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hemebiotech.analytics.constants.ErrorMessages;

public class AnalyticsCounter {
	private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() throws IOException {
		return reader.getSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		if (symptoms == null) {
			logger.error(ErrorMessages.SYMPTOMS_LIST_NULL);
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
	
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}
}
