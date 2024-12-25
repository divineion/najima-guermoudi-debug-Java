package com.hemebiotech.analytics.constants;

/**
 * This class contains constants for informational messages. These messages are
 * used to provide feedback to the user about :
 * <ul>
 * <li>File reading attempts.</li>
 * <li>Empty data situation when processing a Map.</li>
 * <li>Successful writing of output data to a file.</li>
 * </ul>
 * Some messages are formatted with a placeholder ({}), which is used by the
 * log4j Logger to dynamically insert values.
 */
public class InfoMessages {
	public static final String FILE_READ_ATTEMPT = "Attempt to read the file '{}'.";
	public static final String EMPTY_MAP = "The data is empty.";
	public static final String FILE_WRITE_SUCCESS = "The output data has been successfully written to the file 'result.out'.";
}
