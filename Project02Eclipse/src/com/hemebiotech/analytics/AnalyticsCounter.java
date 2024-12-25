package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hemebiotech.analytics.constants.ErrorMessages;

/**
 * This class processes symptom data by reading, counting, ordering and writing
 * the results to an output.
 */
public class AnalyticsCounter {
	private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructs an AnalyticsCounter instance with the provided reader and writer
	 * implementations.
	 * 
	 * @param reader an implementation of {@link ISymptomReader} to read symptom
	 *               data.
	 * @param writer an implementation of {@link ISymptomWriter} to write results.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves the raw list of symptoms from the data source defined by the
	 * reader. Each symptom is included as many times as it is reported in the
	 * source file.
	 * 
	 * @return a {@link List} of {@link String} where each element represents a
	 *         symptom.
	 * @throws IOException in an I/O error occurs while reading the data source.
	 */
	protected List<String> getSymptoms() throws IOException {
		return reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom in the provided list.
	 * 
	 * @param symptoms a {@link List} of {@link String} representing the raw
	 *                 symptoms data.
	 * @return a {@link Map} where keys are symptoms as {@link String} and values
	 *         are occurrences as {@link Integer}.
	 */
	protected Map<String, Integer> countSymptoms(List<String> symptoms) {
		if (symptoms == null) {
			logger.error(ErrorMessages.SYMPTOMS_LIST_NULL);
		}

		Map<String, Integer> symptomOccurrences = new HashMap<>();

		for (String symptom : symptoms) {
			if (!symptomOccurrences.containsKey(symptom)) {
				symptomOccurrences.put(symptom, 1);
			} else {
				symptomOccurrences.replace(symptom, symptomOccurrences.get(symptom) + 1);
			}
		}

		return symptomOccurrences;
	}

	/**
	 * Sorts the symptoms alphabetically by their names.
	 *
	 * @param symptoms a {@link Map} of symptoms and their occurrences.
	 * @return a new {@link TreeMap} where the symptoms are automatically sorted in
	 *         alphabetical order.
	 */
	protected Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}

	/**
	 * Writes the sorted symptoms and their occurrences to the output specified by
	 * the writer.
	 *
	 * @param symptoms a {@link Map} of sorted symptoms and their occurrences.
	 * @throws IOException if an error occurs while writing the data.
	 */
	protected void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}
}
