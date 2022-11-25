package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//chiedo all'utente di istanziare un evento
		System.out.println("Vuoi creare un nuovo evento? Y/N");
		String creationAnswer = sc.nextLine().toLowerCase();
		
		if(creationAnswer.equals("y")) {

			System.out.println("Come si chiama l'evento?");
			String titolo = sc.nextLine();
			
			System.out.println("Inserisci la data dell'evento YYYY-MM-dd");
			LocalDate data = LocalDate.parse(sc.next());
			
			System.out.println("Quante persone può ospitare l'evento?");
			int postiTot = sc.nextInt();
			
			Evento test = new Evento(titolo, data, postiTot);

			
			//chiedo all'utente di gestire le prenotazioni
			System.out.println("Vuoi effettuare una o più prenotazioni? 1 = Y/0 = N");
			int prenAnswer = sc.nextInt();
			
			if(prenAnswer == 1) {
				
				System.out.println("Quante prenotazioni vuoi effettuare?");
				int prenNum = sc.nextInt();
				for(int x = 0; x < prenNum; x++) {
					try {
							test.prenota();
						}
						catch(Exception e) {
						  System.err.println(e.getMessage());
						}
				}
				System.out.println("Posti prenotati: " + test.getPostiPren() + "/" + test.getPostiTot());
			}
			
			
			//chiedo all'utente di gestire le disdette
			System.out.println("Vuoi effettuare una o più disedette? 1 = Y/0 = N");
			int disdAnswer = sc.nextInt();
			
			if(disdAnswer == 1) {
				
				System.out.println("Quante disdette vuoi effettuare?");
				int disdNum = sc.nextInt();
				for(int x = 0; x < disdNum; x++) {
					try {
							test.disdici();
						}
						catch(Exception e) {
						  System.err.println(e.getMessage());
						}
				}
				System.out.println("Posti prenotati: " + test.getPostiPren() + "/" + test.getPostiTot());
			}
		} else {
			System.out.println("Ciao");
		}
		sc.close();
	}
}
