package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
	ACTION, ANIMATION, DRAMA, HISTORY, SCIFI, ROMANCE;
	
	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}
}
