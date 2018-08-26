package br.com.challenge.camaroti.alex.thirdquestion;

public class CheckWordTypoUtil {

	public static void main(String[] args) {

		/*
		 * There are three types of typos that can be performed on strings: insert a
		 * character, remove a character, or replace a character. Given two strings,
		 * write a function to check if they are one typo (or zero typos) away.
		 * Examples: 
		 * pale, ple -> true 
		 * pales, pale -> true 
		 * pale, bale -> true 
		 * pale, bake -> false
		 * 
		 */

		
		String firstWord = "pale";
		String secondWord = "ple";
		
		System.out.println(isTypoWord(firstWord, secondWord));
		
		
	}

	private static boolean isTypoWord(String firstWord, String secondWord) {
		String chosenWord = "";
		String alternativeWord = "";
		int countTypo = 0;
		if(firstWord.length() < secondWord.length()  ||
				firstWord.length() == secondWord.length()) {
			chosenWord = firstWord;
			alternativeWord = secondWord;
		} else if (firstWord.length() > secondWord.length()) { 
			chosenWord = secondWord;
			alternativeWord = firstWord;
		}
		
		for (int i = 0; i < chosenWord.length(); i++) {
			alternativeWord = alternativeWord.replaceFirst(Character.toString(firstWord.charAt(i)), "");
		}
		
		countTypo = countTypo + alternativeWord.length();
		if(countTypo == 0 || countTypo  > 1) {
			return false;
		}
		else {
			return true;
		}
	}
}
