package unpackingastring;

public class Tools {
	
	public static void Unpacking(String originalString) {
		char[] temporaryCharArray = originalString.toCharArray();
		char[] temporarySecondCharArray = new char[temporaryCharArray.length];
		byte parenthesesCounter = 0;
		int multiplier = 0;
		int characterNumberFirst = 0;
		int characterNumberFirst2 = 0;
		int characterNumberSecond = 0;
		boolean checkingForParentheses = false;
		
		while(true){
			if(Character.isDigit(temporaryCharArray[characterNumberFirst])) {
				multiplier=multiplier * 10 + Character.getNumericValue(temporaryCharArray[characterNumberFirst]);
			}else if(temporaryCharArray[characterNumberFirst]=='['){
				temporarySecondCharArray=IncreaseSize(temporarySecondCharArray, multiplier, characterNumberSecond, characterNumberFirst);
				characterNumberFirst++;
				characterNumberFirst2=characterNumberFirst;
				for(int i=0; i<multiplier;i++) {
					characterNumberFirst = characterNumberFirst2;
					parenthesesCounter=1;
					while(parenthesesCounter>0) {
						if(temporaryCharArray[characterNumberFirst]==']') {
							parenthesesCounter--;
							if(parenthesesCounter>0) {
								temporarySecondCharArray[characterNumberSecond]=temporaryCharArray[characterNumberFirst];
								characterNumberFirst++;
								characterNumberSecond++;
							}
						}else if(temporaryCharArray[characterNumberFirst]=='[') {
							parenthesesCounter++;
							if(parenthesesCounter>1) {
								checkingForParentheses=true;
							}
							temporarySecondCharArray[characterNumberSecond]=temporaryCharArray[characterNumberFirst];
							characterNumberSecond++;
							characterNumberFirst++;
						}else {
							temporarySecondCharArray[characterNumberSecond]=temporaryCharArray[characterNumberFirst];
							characterNumberSecond++;
							characterNumberFirst++;
						}
					}
				}
				multiplier = 0;
			}else if(temporaryCharArray[characterNumberFirst]==']'){
				parenthesesCounter--;
			}else{
				temporarySecondCharArray[characterNumberSecond]=temporaryCharArray[characterNumberFirst];
				characterNumberSecond++;
			}
			characterNumberFirst++;
			if(characterNumberFirst>=temporaryCharArray.length) {
				characterNumberFirst=0;
				characterNumberSecond=0;
				if(!checkingForParentheses) {
					break;
				}
				temporaryCharArray=temporarySecondCharArray;
				checkingForParentheses=false;
				parenthesesCounter=0;
				}
		}
		PrintArray(temporarySecondCharArray);
	}
	
	private static char[] IncreaseSize(char[] array, int multiplier, int arraySaveLength, int lengthSecond) {
		char[] increaseArray = new char[arraySaveLength + (array.length - lengthSecond - 2)*multiplier];

		for (int i = 0; i < arraySaveLength; i++){
			increaseArray[i] = array[i];
		}
		return increaseArray;
	}
	
	private static void PrintArray(char[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(Character.toString(array[i]));
		}
		System.out.println("");
	}
	
	public static boolean validationInputString(String inputString) {
		char[] inputStringArray = inputString.toCharArray();
		char[] verificationCharactersArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
											  'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
											  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
											  'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
											  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int ParenthesesCount = 0;
		boolean checkFirst = false;
		boolean checkSecond = true;
		
		for(int i=0; i < inputStringArray.length; i++) {
			if(inputStringArray[i] == '[') {
				ParenthesesCount++;
			}else if(inputStringArray[i] == ']') {
				ParenthesesCount--;
			}else {
				for(int j=0; j<verificationCharactersArray.length; j++) {
					if(verificationCharactersArray[j] == inputStringArray[i]) {
						checkFirst = true;
						break;
					}
				}
				if(!checkFirst && checkSecond) {
					System.out.println("Invalid character entered.");
					checkSecond = false;
				}
				checkFirst = false;
			}
		}
		if(ParenthesesCount != 0) {
			System.out.println("The number of opening square brackets must be equal to the number of closing "
					+ "square brackets.");
			checkSecond = false;
		}
		if(!checkSecond) {
			System.out.println("Please repeat the input.");
		}
		return checkSecond;
	}
}
