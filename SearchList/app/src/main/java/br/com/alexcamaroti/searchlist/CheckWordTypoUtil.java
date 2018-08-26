package br.com.alexcamaroti.searchlist;

public class CheckWordTypoUtil {

	public static void main(String[] args) {

	}

	public static boolean isTypoWord(String firstWord, String secondWord) {
		String chosenWord = "";
		String alternativeWord = "";
		int countTypo = 0;
		if (firstWord.length() < secondWord.length() ||
				firstWord.length() == secondWord.length()) {
			chosenWord = firstWord;
			alternativeWord = secondWord;
		} else if (firstWord.length() > secondWord.length()) {
			chosenWord = secondWord;
			alternativeWord = firstWord;
		}

		for (int i = 0; i < chosenWord.length(); i++) {
			alternativeWord = alternativeWord.replaceFirst(Character.toString(chosenWord.charAt(i)), "");
		}

		countTypo = countTypo + alternativeWord.length();
		if (countTypo > 1) {
			return false;
		} else {
			return true;
		}
	}
}
