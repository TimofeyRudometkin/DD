package unpackingastring;

import java.util.Scanner;

public class UnpackingAString {
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String inputString = "";
		System.out.println("Hello! Enter a string like:");
		System.out.println("2[Hello2[world]3[!]]");
		System.out.println("And get the string like: ");
		Tools.Unpacking("2[Hello2[world]3[!]]");
		System.out.println("Enter 'exit' for exit from program.");
		
		while(true) {
			inputString = inputScanner.next();
			if(inputString.equals("exit")) {
				break;
			}
			if(Tools.validationInputString(inputString)) {
				Tools.Unpacking(inputString);
			}
		}
		inputScanner.close();
		System.exit(0);
	}
}
