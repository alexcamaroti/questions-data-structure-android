package br.com.challenge.camaroti.alex.secondquestion;

public class JumbledLettersUtil {

	public static void main(String[] args) {

		/*
		 * Our brain can read texts even if letters are jumbled, like the following
		 * sentence: “Yuo cna porbalby raed tihs esaliy desptie teh msispeillgns.” Given
		 * two words, write a method to decide if one is a partial-permutation of the
		 * other. Consider a partial-permutation only if: - The first letter hasn’t
		 * changed place - If word has more than 3 letters, up to 2/3 of the letters
		 * have changed place.
		 * 
		 * Examples: you, yuo -> true 
		 * probably, porbalby -> true 
		 * despite, desptie -> true 
		 * moon, nmoo -> false 
		 * misspellings, mpeissngslli -> false
		 */

		String firstWord = "probably";
		String secondWord = "porbalby";
		System.out.println(jumbledLetters(firstWord, secondWord));

	}

	private static boolean jumbledLetters(String firstWord, String secondWord) {
		int minimumLetters = 3;
		String[] firstWordSplitted = firstWord.split("");
		String[] secondWordSplitted = secondWord.split("");
		int counterJumbled = 0;

		if (firstWord.charAt(0) == secondWord.charAt(0)) {

			if (firstWord.length() > minimumLetters && secondWord.length() > minimumLetters) {
				if (firstWord.length() == secondWord.length()) {
					for (int i = 0; i < firstWordSplitted.length; i++) {
						if (!firstWordSplitted[i].equals(secondWordSplitted[i])) {
							counterJumbled++;
						}
					}
				} else if (firstWord.length() > secondWord.length()) {
					counterJumbled = firstWord.length() - secondWord.length();
					for (int i = 0; i < secondWordSplitted.length; i++) {
						if (!firstWordSplitted[i].equals(secondWordSplitted[i])) {
							counterJumbled++;
						}
					}

				} else if (firstWord.length() < secondWord.length()) {
					counterJumbled = secondWord.length() - firstWord.length();
					for (int i = 0; i < firstWordSplitted.length; i++) {
						if (!firstWordSplitted[i].equals(secondWordSplitted[i])) {
							counterJumbled++;
						}
					}
				}
				
				return calcFrac(firstWord, counterJumbled);

			} else {
				for (int i = 0; i < firstWordSplitted.length; i++) {
					if(!firstWordSplitted[i].equals(secondWordSplitted[i])) {
						counterJumbled++;
					}
				}
				return calcFrac(firstWord, counterJumbled);
			}

		} else {
			return false;
		}
	}

	private static boolean calcFrac(String firstWord, int counterJumbled) {
		if(counterJumbled == 0) {
			return false;
		} else {
			float resultFrac = (float)(counterJumbled * 100) / firstWord.length();
			if(resultFrac > 66.6666666667) {
				return false;
			} else {
				return true;
			}

		}
	}

}
