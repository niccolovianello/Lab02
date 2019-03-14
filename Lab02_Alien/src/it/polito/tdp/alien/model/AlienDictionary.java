package it.polito.tdp.alien.model;

import java.util.*;

public class AlienDictionary {
	
	private Map<String, String> dictionary = new TreeMap<String, String>();;
	
	public AlienDictionary() {
	}

	public void addWord(String alienWord, String translation) {
		dictionary.put(alienWord, translation);
	}
	
	public String translateWord(String alienWord) {
		return dictionary.get(alienWord);
	}

}
