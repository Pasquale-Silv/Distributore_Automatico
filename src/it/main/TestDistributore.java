/**
 * 
 */
package it.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import it.classi.Disegno;
import it.classi.DistributoreAutomatico;

public class TestDistributore {
	static int sceltaAdmin = 0;

	static String sceltaUtente = "";
	static String passwordAcquisita;
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		DistributoreAutomatico d = new DistributoreAutomatico();

		System.out.println("Benvenuto nel programma di gestione del Distributore Automatico...");
		System.out.println("La macchina attualmente è spenta.");

		System.out.println("Per mettere in funzione il Distributore premere un tasto");
		System.out.println("Per uscire premere x");
		String inserito = in.next();
		if (inserito.equalsIgnoreCase("x")) {
			System.exit(1000);
		}
		if (inserito != null) {
			d.accendiSpegni();

			do {

				System.out.println();

				System.out.println(
						"Premi 1 per acquistare.\nPremi 2 per accedere come amministratore.\nPremi 3 per uscire dal programma.");
				sceltaUtente = in.next();
				if (sceltaUtente.equalsIgnoreCase("3")) {
					System.exit(1000);
				}
				if (sceltaUtente.equalsIgnoreCase("1")) {
					if (DistributoreAutomatico.distributore.size() > 0) {
						d.acquista();
					} else {
						System.out.println("La Macchinetta è attualmente vuota");
					}

				} else if (sceltaUtente.equalsIgnoreCase("2")) {
					Disegno.StampaApeChiDisplay(80);
					Disegno.StampaStringaNotCap("Inserire la password per accedere alla sezione protetta.");
					passwordAcquisita = in.next();
					Disegno.StampaStringa("");
					if (passwordAcquisita.equals(DistributoreAutomatico.getPasswordamministratore())) {
						Disegno.StampaStringa("Benvenuto nella sezione protetta Admin");
						Disegno.StampaApeChiDisplay(80);
						do {

							try {
								Disegno.StampaApeChiDisplay(80);
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							Disegno.StampaStringa("");
							Disegno.StampaStringaNotCap("Premere 1: Per inserimento prodotti ");
							System.out.println();
							Disegno.StampaStringaNotCap("Premere 2: Per ricaricare la cassa");
							System.out.println();
							Disegno.StampaStringaNotCap("Premere 3: Per stampare il resoconto vendite");
							System.out.println();
							Disegno.StampaStringaNotCap("Premere 4: Per prelevare il saldo cassa");
							System.out.println();
							Disegno.StampaStringaNotCap("Premere 5: Per spegnere il Distributore");
							System.out.println();
							Disegno.StampaStringaNotCap("Premere 6: Tornare al menù principale");
							String StringsceltaAdmin = in.next();
							try {
								sceltaAdmin = new Integer(StringsceltaAdmin);
							} catch (NumberFormatException e) {
								Disegno.StampaStringa("");
								Disegno.StampaStringa("Puoi inserire solo un'intero");
							}
							Disegno.StampaStringa("");
							switch (sceltaAdmin) {
							case 1:
								d.caricaProdotto();
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;
							case 2:
								d.ricaricaCassa();
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;
							case 3:
								d.stampaResoconto();
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;
							case 4:
								d.svuotaCassa();
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;
							case 5:
								d.accendiSpegni();
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;
							case 6:

								Disegno.StampaStringa("Uscita...");
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								break;

							default:

								Disegno.StampaStringa("Scelta non valida, inserire nuovamente");
								Disegno.StampaApeChiDisplay(80);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;
							}
						} while (sceltaAdmin != 6 && sceltaAdmin != 5);

					} else {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Disegno.StampaStringa("Password errata...");
						Disegno.StampaApeChiDisplay(80);

					}
				} else {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Scelta non valida...");

				}
			} while (d.isOn());
		}
	}
}