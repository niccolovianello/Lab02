package it.polito.tdp.alien.model;

public class Word {

	private String alienWord;
	private String translation;

	public Word(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}
	
	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public boolean equals(Object anObject) {
		
		Word w = (Word) anObject;
		if(w.getAlienWord().compareTo(this.alienWord) == 0) {
			return true;
		}
		else return false;
	}
	
	

	/*public String getTraduzioni() {
		String s = "";
		if(traduzioni.size() == 1) {
			for(String t : traduzioni) {
				s += t;
				return s;
			}
		}
		
		else {
			for(String t : traduzioni) {
				s += t+ "\n";
			}
			return s.trim();
		}
		return null;	
	}
	
	public void addTraduzione(String tr) {
		traduzioni.add(tr);
	}*/

}
