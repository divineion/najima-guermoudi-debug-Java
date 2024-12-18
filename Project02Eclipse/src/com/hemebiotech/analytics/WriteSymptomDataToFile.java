package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private Map<String, Integer> symptomsOccurrences;
	
	public WriteSymptomDataToFile(Map<String, Integer> symptomsOccurrences) {
		this.symptomsOccurrences = symptomsOccurrences;
	}
	
	@Override
	public void writeSymptoms() {
		try (FileWriter writer = new FileWriter ("result.out")) {
			for (Entry<String, Integer> symptomOccurrence : symptomsOccurrences.entrySet()) {
				writer.write(symptomOccurrence.getKey() + " : " + symptomOccurrence.getValue() + "\n");
			}
			
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
