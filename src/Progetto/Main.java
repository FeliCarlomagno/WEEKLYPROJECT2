package Progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	static class Biblioteca{
		private List<Libro> libri = new ArrayList<>();
		private List <Rivista> riviste = new ArrayList<>();
		
		public void aggiungiLibro(Libro libro) {
			libri.add(libro);
		}
		
		public void aggiungiRivista(Rivista rivista) {
			riviste.add(rivista);
		}
		
		public void rimuoviTramiteISBN( String codiceISBN) {
			libri.removeIf(libro -> libro.getCodiceISBN().equals(codiceISBN));
			riviste.removeIf(rivista -> rivista.getCodiceISBN().equals(codiceISBN));
		}
		
		
		//RICERCA PER CODICE ISBN:
		public void ricercaPerISBN(String isbn) {
		    List<ElementoCatalogo> risultatiRicerca = Stream.concat(libri.stream(), riviste.stream())
		            .filter(elemento -> elemento.getCodiceISBN().equals(isbn))
		            .collect(Collectors.toList());

		    if (risultatiRicerca.isEmpty()) {
		        System.out.println("Nessun elemento trovato");
		       } else {
		        System.out.println(risultatiRicerca);
		    }
		}
		
		
		//RICERCA PER ANNO DI PUBBLICAZIONE:
		public void ricercaPerAnnoPubblicazione(int anno) {
		    List<ElementoCatalogo> risultatiRicerca = Stream.concat(libri.stream(), riviste.stream())
		            .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
		            .collect(Collectors.toList());

		    if (risultatiRicerca.isEmpty()) {
		        System.out.println("Nessun elemento trovato");
		} else {
		System.out.println(risultatiRicerca);
		  }
		}
		
		
		//RICERCA PER AUTORE:
		public void ricercaPerAutore(String autore) {
		    List<Libro> risultatiRicerca = libri.stream()
		            .filter(libro -> libro.getAutore().equals(autore))
		            .collect(Collectors.toList());

		    if (risultatiRicerca.isEmpty()) {
		        System.out.println("Nessun elemento trovato");
		    } else {
		        System.out.println(risultatiRicerca);
		    }
		}
		 
		
		
		public void stampaCatalogo() {
			    System.out.println("\n Libri:");
			    libri.forEach(System.out::println);
			    System.out.println("\n Riviste:");
			    riviste.forEach(System.out::println);
			}
		
	
	}

	public static void main(String[] args) {
		
		 Biblioteca catalogoBibliotecario = new Biblioteca();
		String scelta;
		
		do {
			 System.out.println("\n Scegli un'operazione da eseguire: \n");
	            System.out.println("1. Aggiungi un libro;");
	            System.out.println("2. Aggiungi una rivista;");
	            System.out.println("3. Rimuovi un elemento dato da un codice ISBN;");
	            System.out.println("4. Ricerca per ISBN;");
	            System.out.println("5. Ricerca per anno di pubblicazione;");
	            System.out.println("6. Ricerca per autore;");
	            System.out.println("7. Stampa catalogo;");
	            System.out.println("0. Esci");
			
			scelta = scanner.nextLine();
			
			switch(scelta) {
			    case "1":
			    	System.out.println("\n Inserisci il codiceISBN: ");
			    	String codiceISBN = scanner.nextLine();
			    	System.out.println("Inserisci il titolo: ");
			    	String titoloLibro = scanner.nextLine();
			    	System.out.print("Inserisci l'anno di pubblicazione: ");
	                int annoPubblicazioneLibro = scanner.nextInt();
	                scanner.nextLine();
	                System.out.print("Inserisci il numero di pagine: ");
                    int numeroPagineLibro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Inserisci l'autore: ");
                    String autoreLibro = scanner.nextLine();
                    System.out.print("Inserisci il genere: ");
                    String genereLibro = scanner.nextLine();
                    
                    catalogoBibliotecario.aggiungiLibro(new Libro(codiceISBN, titoloLibro, annoPubblicazioneLibro, numeroPagineLibro, autoreLibro, genereLibro));
                    System.out.println("\n ** NUOVO LIBRO CREATO CORRETTAMENTE** \n");
                    break;
                    
			    case "2":
			    	 System.out.print("Inserisci il codice ISBN: ");
		             String ISBNRivista = scanner.nextLine();
		             System.out.print("Inserisci il titolo: ");
		             String titoloRivista = scanner.nextLine();
		             System.out.print("Inserisci l'anno di pubblicazione: ");
		             int annoPubblicazioneRivista = scanner.nextInt();
		             scanner.nextLine();
		             System.out.print("Inserisci il numero di pagine: ");
		             int numeroPagineRivista = scanner.nextInt();
		             scanner.nextLine();
		             System.out.print("Inserisci la periodicità (settimanale, mensile o semestrale): ");
		             String periodicitàRivista = scanner.nextLine();
		             catalogoBibliotecario.aggiungiRivista(new Rivista(ISBNRivista, titoloRivista, annoPubblicazioneRivista, numeroPagineRivista, Periodicità.valueOf(periodicitàRivista)));
		             System.out.println("\n ** NUOVA RIVISTA CREATO CORRETTAMENTE** \n");
		             break;
		             
			    case "3":
			    	System.out.println("Inserisci il codice ISBN dell'elemento da rimuovere: ");
			    	String ISBNdaRimuovere = scanner.nextLine();
			    	catalogoBibliotecario.rimuoviTramiteISBN(ISBNdaRimuovere);
			    	break;
			    	
			    case "4" :
			    	System.out.println("\n Inserisci il codice ISBN dell'elemento che vuoi cercare: ");
			    	String ISBNdaCercare = scanner.nextLine();
			    	catalogoBibliotecario.ricercaPerISBN(ISBNdaCercare);
			    	break;
			    	
			    case "5" : 
			    	System.out.println("\n Inserisci l'anno di pubblicazione da cercare: ");
			    	int annoDaCercare = scanner.nextInt();
			    	scanner.nextLine();
			    	catalogoBibliotecario.ricercaPerAnnoPubblicazione(annoDaCercare);
			    	break;
			    	
			    case "6" : 
			    	System.out.println("\n Inserisci l'autore da cercare: ");
			    	String cercaAutore = scanner.nextLine();
			    	catalogoBibliotecario.ricercaPerAutore(cercaAutore);
			    	break;
			    	
			    case "7": 
			    	System.out.println("\n Ecco a te il catalogo completo: \n");
			    	catalogoBibliotecario.stampaCatalogo();
			    	break;
			    	
			    case "0" : 
			    	System.out.println("\n A presto! \n");
			    	break;
			    	
			   default:
				   System.out.println("\n !!Inserimento non valido");
				   break;
			}
			
		} while (!scelta.equals("0"));

	}

}
