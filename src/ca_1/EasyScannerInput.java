package ca_1;

public class EasyScannerInput {

    public static int readNextInt(String input) {
	do {

	    try {
		System.out.print(input);
		return Integer.parseInt(EasyScanner.nextString());
	    } catch (NumberFormatException e) {
		System.err.println("\tEnter a number please.");
	    }
	} while (true);
    }

    public static String validNextLine(String prompt) {

	System.out.print(prompt);
	return EasyScanner.nextString();
    }

}