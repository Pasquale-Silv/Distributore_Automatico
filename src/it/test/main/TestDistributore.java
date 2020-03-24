package it.test.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import it.classe.base.DistributoreAutomatico;

public class TestDistributore {
	static int sceltaAdmin = 0;

	static String sceltaUtente = "";
	static String passwordAcquisita;
	private static Scanner in;

	public static void main(String[] args)throws InputMismatchException {
		in = new Scanner(System.in);
		DistributoreAutomatico d = new DistributoreAutomatico();

		System.out.println("Benvenuto nel programma di gestione del Distributore Automatico...");
		System.out.println("La macchina attualmente è spenta.");

		System.out.println("Per mettere in funzione il Distributore premere un tasto");
		String inserito = in.next();

		if (inserito != null) {
			d.accendiSpegni();
			do {
				System.out.println("Premi 1 per acquistare.\nPremi 2 per accedere come amministratore. ");
				sceltaUtente = in.next();
				if (sceltaUtente.equalsIgnoreCase("1")) {
				try {d.acquista();
					
				} catch (InputMismatchException e) {
					System.out.println("Errore non puoi inserire Caratteri");
					
				} 	
				} else if (sceltaUtente.equalsIgnoreCase("2")) {
					System.out.println("Inserire la password per accedere alla sezione protetta.");
					passwordAcquisita = in.next();
					if (passwordAcquisita.equals(DistributoreAutomatico.getPasswordamministratore())) {
						System.out.println("Benvenuto nella sezione protetta Admin");
						do {
							System.out.println("premere 1: Per inserimento prodotti ");
							System.out.println("premere 2: Per ricaricare la cassa");
							System.out.println("premere 3: Per stampare il resoconto vendite");
							System.out.println("premere 4: Per prelevare il saldo cassa");
							System.out.println("premere 5: Per spegnere il Distributore");
							System.out.println("premere 6: Per uscire");
							sceltaAdmin = in.nextInt();

							switch (sceltaAdmin) {
							case 1:
								d.caricaProdotto();
								break;
							case 2:
								d.ricaricaCassa();
								break;
							case 3:
								d.stampaResoconto();
								break;
							case 4:
								d.svuotaCassa();
								break;
							case 5:
								d.accendiSpegni();
								break;
							case 6:
								System.out.println("Uscita...");
								break;

							default:
								System.out.println("Scelta non valida, inserire nuovamente");
								break;
							}

						} while (sceltaAdmin != 6 && sceltaAdmin != 5);

					} else {
						System.out.println("Password errata...Riprovare");
					}
				} else {
					System.out.println("Scelta non valida...");

				}
			} while (d.isOn());
		}
	}
}