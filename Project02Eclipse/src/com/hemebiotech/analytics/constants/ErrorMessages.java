package com.hemebiotech.analytics.constants;

/**
 * This class contains constants for error messages. 
 * These messages are used to provide feedback to the user about :  
 * <ul>
 * <li>Issues while reading a file.</li>
 * <li>Null symptom list during processing.</li>
 * <li>Any unexpected error during execution.</li>
 * </ul>
 * Some messages are formatted with a placeholder ({}), which is used by the log4j Logger to dynamically insert values. 
 */
public class ErrorMessages {
	public static final String FILE_NOT_FOUND = "The specified file '{}' could not be found. Please check the file path and try again.";
	public static final String SYMPTOMS_LIST_NULL = "The symptoms list cannot be null.";
	public static final String UNEXPECTED_ERROR = "An unexpected error occurred : {}";
}
