package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm() {
		 Scanner scanner = new Scanner(System.in);
		    System.out.println("Enter film number:");
		    int filmNr = scanner.nextInt();
		    // ... (similarly read other film details: title, producer, etc.)
		    System.out.println("Enter sjanger (e.g., ACTION, DRAMA):");
		    String genre = scanner.next();
		    Sjanger sjanger = Sjanger.valueOf(genre.toUpperCase());
		    return null;  // Fill in other parameters
		}
	

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		// TODO
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		// TODO
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		// TODO
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		// TODO
	}
	// osv ... andre metoder

}
