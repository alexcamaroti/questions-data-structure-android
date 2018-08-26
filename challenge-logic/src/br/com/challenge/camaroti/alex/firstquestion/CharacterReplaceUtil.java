package br.com.challenge.camaroti.alex.firstquestion;

import java.util.ArrayList;

public class CharacterReplaceUtil {

	public static void main(String[] args) {

		/*
		 * Given an array of characters​, write a method to replace all the spaces with
		 * “&32”. You may assume that the array has sufficient slots at the end to hold
		 * the additional characters, and that you are given the “true” length of the
		 * array. (Note:​ Please perform this operation in same array provided​ and
		 * without any String methods​).
		 * 
		 * Example: Input: “User is not allowed “, 19 Output:
		 * “User&32is&32not&32allowed”
		 */

		char[] characters = { 'u', 's', 'e', 'r', ' ', 'i', 's', ' ', 'n', 'o', 't', ' ', 'a', 'l', 'l', 'o', 'w', 'e',
				'd' };
		replace(characters);
		
		
		

	}

	private static void replace(char[] characters) {
		ArrayList<Integer> emptyLettersPosition = new ArrayList<Integer>();
		int countAux = 0;

		
		//Getting positions of empty characters.
		for (int i = characters.length - 1; i >= 0; i--) {
			if (characters[i] == ' ') {
				emptyLettersPosition.add(i);
			}
		}

		//Defining the size of the auxiliar array
		char[] charactersAux = new char[characters.length + (emptyLettersPosition.size() * 2)];

		//Starting by the first empty character.
		int positionEmptyArray = emptyLettersPosition.get(countAux);
		int positionSavedAuxArray = charactersAux.length - 1;
		
		for (int i = characters.length - 1; i >= positionEmptyArray; i--) {
				charactersAux[positionSavedAuxArray] = characters[i];
				positionSavedAuxArray--;
				
				if(i == positionEmptyArray && i != 0){
					countAux++;
					charactersAux[positionSavedAuxArray] = '3';
					charactersAux[positionSavedAuxArray - 1] = '&';
					charactersAux[positionSavedAuxArray + 1] = '2';
					positionSavedAuxArray = positionSavedAuxArray-2;
					if(emptyLettersPosition.size() != countAux) {
						positionEmptyArray = emptyLettersPosition.get(countAux);
					}
					else {
						positionEmptyArray = 0;
					}
				}
		}
		//Setting the new content to the main variable
		characters = charactersAux;
		
		System.out.println(characters);
	}

}
