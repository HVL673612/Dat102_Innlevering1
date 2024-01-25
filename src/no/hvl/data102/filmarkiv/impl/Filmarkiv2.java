package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> current = start;
		while (current != null) {
			if (current.getElement().getFilmNr() == nr) {
				return current.getElement();
			}
			current = current.getNeste();
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;

	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> current = start;
		LinearNode<Film> forrige = null;

		while (current != null) {
			if (current.getElement().getFilmNr() == filmnr) {
				if (forrige == null) {
					start = current.getNeste();
				} else {
					forrige.setNeste(current.getNeste());
				}
				antall--;
				return true;
			}
			forrige = current;
			current = current.getNeste();
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> current = start;
		LinearNode<Film> titelStart= null, titelSlutt= null;
		int i = 0;
		
		while(current != null) {
			if(current.getElement().getTittel().contains(delstreng)) {
				LinearNode<Film> titelSok = new LinearNode<>(current.getElement());
				if(titelStart == null) {
					titelStart = titelSok;
				}else {
					titelSlutt.setNeste(titelSok);
				}
				titelSlutt = titelSok;
				i++;
			}
			current = current.getNeste();
		}
		return konverterToArray(titelStart,i);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> current = start;
		LinearNode<Film> produsentStart= null, produsentSlutt= null;
		int i = 0;
		
		while(current != null) {
			if(current.getElement().getProdusent().contains(delstreng)) {
				LinearNode<Film> produsentSok = new LinearNode<>(current.getElement());
				if(produsentStart == null) {
					produsentStart = produsentSok;
				}else {
					produsentSlutt.setNeste(produsentSok);
				}
				produsentSlutt = produsentSok;
				i++;
			}
			current = current.getNeste();
		}
		return konverterToArray(produsentStart,i);
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> current = start;
		int antSjanger = 0;
		
		while (current != null) {
			if(current.getElement().getSjanger() == sjanger) {
				antSjanger++;
			}
			current = current.getNeste();
		}
		return antSjanger;
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	private Film[] konverterToArray(LinearNode<Film> a, int storelse) {
		Film[] konvertert = new Film[storelse];
		int i = 0;
		LinearNode<Film> current = a;
		
		while(current != null) {
			konvertert[i++] = current.getElement();
			current = current.getNeste();
		}
		return konvertert;
		
	}

}
