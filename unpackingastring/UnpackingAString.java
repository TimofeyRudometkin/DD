package unpackingastring;

//import com.sun.java_cup.internal.runtime.Scanner;
import java.util.Scanner;
//import javax.tools.Tool;

public class UnpackingAString {
	public static void main(String[] args) {
		//сначала валидация if true then unpacking
		Scanner inputScanner = new Scanner(System.in);
		String inputString = "";
		System.out.println("Hello! Enter a string like:");
		System.out.println("2[Hello2[world]3[!]]");
		System.out.println("And get the string like: ");
		Tools.Unpacking("2[Hello2[world]3[!]]");
		System.out.println("Enter 'exit' for exit from program.");
		
		while(inputString != "exit") {
			inputString = inputScanner.nextLine();
			Tools.Unpacking(inputString);
		}
		inputScanner.close();
	}

}
