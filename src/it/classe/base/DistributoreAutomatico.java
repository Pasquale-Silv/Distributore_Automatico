package it.classe.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.jndi.toolkit.url.Uri;

import items.AcquaM;
import items.Bounty;
import items.CocaCola;
import items.Crostino;
import items.Kbueno;
import items.Mars;

import items.Sprite;
import items.Sticks;
import items.Tramezzino;
import jdk.jfr.events.FileWriteEvent;
import utils.Distributore;
import utils.Item;
import utils.Monete;

public class DistributoreAutomatico implements Distributore, Monete {
	private static final String PASSWORDAMMINISTRATORE = "Admin";
	private static int contaDueEuro = 0;
	private static int contaUnEuro = 0;
	private static int contaCinquantaCent = 0;
	private static int contaVentiCent = 0;
	private static int contaDieciCent = 0;
	private static float resto;
	private static boolean isOn = false;
	private static ArrayList<String> listaVendite = new ArrayList<String>();
	private static float saldoCassa;
	private static int contaProdottoVenduto;
	private static float guadagnoCassa;
	Scanner in = new Scanner(System.in);
	private float raggiungiImporto = 0;
	private float quantoManca = 0;

	 static HashMap<Integer, ArrayList> distributore = new HashMap<Integer, ArrayList>();

	public static String getPasswordamministratore() {
		return PASSWORDAMMINISTRATORE;
	}

	@Override
	public void accendiSpegni() {
		if (!isOn) {
			isOn = true;
			System.out.println("Il distributore Ë acceso.");
		} else {
			if (isOn) {
				isOn = false;
				System.out.println("Spegnimento in corso.....");

			}
		}

	}

	public static boolean isOn() {
		return isOn;
	}

	@Override
	public float calcolaResto() {
		int cont = 0;

		resto = raggiungiImporto - quantoManca;

		do {
			cont++;
			while (resto >= 2 && contaDueEuro > 0) {
				System.out.println(DUEEURO);
				resto = resto - DUEEURO;
				contaDueEuro--;
			}
			while (resto >= 1 && contaUnEuro > 0) {
				System.out.println(UNEURO);
				resto = resto - UNEURO;
				contaUnEuro--;
			}
			while (resto >= 0.50 && contaCinquantaCent > 0) {
				System.out.println(CINQUANTACENT);
				resto = resto - CINQUANTACENT;
				contaCinquantaCent--;
			}
			while (resto >= 0.20 && contaVentiCent > 0) {
				System.out.println(VENTICENT);
				resto = resto - VENTICENT;
				contaVentiCent--;
			}
			while (resto >= 0.10 && contaDieciCent > 0)

			{
				System.out.println(DIECICENT);

				resto = resto - DIECICENT;
				contaDieciCent--;
			}

		} while (cont != 20);
		if (cont == 20) {
			System.out.println("Non Ë possibile erogare completamente il resto.");

		} else {
			System.out.println("Resto: " + resto + " Ä");

		}
		saldoCassa -= resto;

		return resto;

	}

	@Override
	public void acquista() {
		boolean controlloScelta = false;
		int scelta = 0;
		if (!isOn) {

			System.out.println("Il distributore Ë spento...");
		} else {
			String sceltaDisegno=" ";
			Disegno.StampaMacchinetta(sceltaDisegno);
			System.out.println();
			System.out.println();
			Disegno.StampaApeChiDisplay(57);

			do {
				if (saldoCassa < 2 && contaDieciCent < 1 || contaVentiCent < 1 || contaCinquantaCent < 1
						|| contaUnEuro < 1) {
					Disegno.StampaStringa("ATTENZIONE!!");
					Disegno.StampaStringa("Il distributore potrebbe non avere il resto necessario!!!");
				}
				Disegno.StampaStringa("Scegliere un prodotto dal distributore:");

				scelta = in.nextInt();
					
			

			
					if (scelta< 1 || scelta > 9) {
						Disegno.StampaStringa("Scelta non valida...");
						controlloScelta = true;
					} else {
						if (distributore.isEmpty() || distributore.get(scelta).isEmpty()) {
							Disegno.StampaStringa("Il prodotto selezionato non Ë disponibile.");
							controlloScelta = true;
						} else {
							controlloScelta = false;
						}
					}
					
				
			} while (controlloScelta);
			Disegno.StampaStringa("");
			Disegno.StampaStringa("Inserire: " + ((Item) distributore.get(scelta).get(0)).DammiPrezzo() + "Ä");

			quantoManca = ((Item) distributore.get(scelta).get(0)).DammiPrezzo();

			do {

				Disegno.StampaStringa("Digitare " + "A" + " per inserire 2Ä");Disegno.StampaStringa("Digitare " + "B"
						+ " per inserire 1Ä");Disegno.StampaStringa("Digitare " + "C" + " per inserire 0,50 Ä");Disegno.StampaStringa("Digitare " + "D"
						+ " per inserire 0,20 Ä ");Disegno.StampaStringa("Digitare " + "E" + " per inserire 0,10 Ä");

				String sceltaMonete = in.next();

				switch (sceltaMonete.toUpperCase()) {
				case "A":
					raggiungiImporto += 2;
					contaDueEuro++;

					break;
				case "B":
					raggiungiImporto += 1;
					contaUnEuro++;
					break;
				case "C":
					raggiungiImporto += 0.5;
					contaCinquantaCent++;
					break;
				case "D":
					raggiungiImporto += 0.20;
					contaVentiCent++;
					break;
				case "E":
					raggiungiImporto += 0.10;
					contaDieciCent++;
					break;

				default:
					Disegno.StampaStringa("ATTENZIONE!!!!Moneta non accettata!!!");
					break;
				}
				float restoCheManca = quantoManca - raggiungiImporto;
				if (restoCheManca > 0)
					Disegno.StampaStringa("Devi inserire ancora: " + (restoCheManca) + " Ä");

			} while (!(raggiungiImporto >= quantoManca));

			saldoCassa += raggiungiImporto;
			guadagnoCassa += quantoManca;
			contaProdottoVenduto++;

			Disegno.StampaStringa("Erogazione prodotto...");
			Disegno.StampaApeChiDisplay(57);
			sceltaDisegno=((Item) distributore.get(scelta).get(0)).DammiNome();
			

			DateTimeFormatter time = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm");
			String formattata = LocalDateTime.now().format(time);
			String nomeProdotto = ((Item) distributore.get(scelta).get(0)).toString();
			String datoVendita = formattata + "\t" + nomeProdotto;
			listaVendite.add(datoVendita);
			distributore.get(scelta).remove(0);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Disegno.StampaMacchinetta(sceltaDisegno);
            Disegno.StampaStringa("");
			

			if (raggiungiImporto > quantoManca) {

				calcolaResto();
				Disegno.StampaStringa("Arrivederci");
				raggiungiImporto = 0;
			} else {
				raggiungiImporto = 0;
				Disegno.StampaStringa("Arrivederci");
			}

		}

	}

	@Override
	public float svuotaCassa() {
		Disegno.StampaStringa("Dalla cassa sono stati prelevati " + saldoCassa + "Ä");
		saldoCassa = 0;
		return saldoCassa;
	}

	@Override
	public void ricaricaCassa() {
		float valoreTotaleInserito = 0;
		Disegno.StampaStringa("Quante monete da 2Ä vuoi inserire?");
		int quantit‡Moneta = in.nextInt();
		contaDueEuro += quantit‡Moneta;
		valoreTotaleInserito += quantit‡Moneta * 2;
		Disegno.StampaStringa("Quante monete vuoi inserireda 1Ä vuoi inserire?");
		quantit‡Moneta = in.nextInt();
		contaUnEuro += quantit‡Moneta;
		valoreTotaleInserito += quantit‡Moneta * 1;
		Disegno.StampaStringa("Quante monete da 0.50Ä vuoi inserire?");
		quantit‡Moneta = in.nextInt();
		contaCinquantaCent += quantit‡Moneta;
		valoreTotaleInserito += quantit‡Moneta * 0.5;
		Disegno.StampaStringa("Quante monete da 0.20Ä vuoi inserire?");
		quantit‡Moneta = in.nextInt();
		contaVentiCent += quantit‡Moneta;
		valoreTotaleInserito += quantit‡Moneta * 0.2;
		Disegno.StampaStringa("Quante monete da 0.10Ä  vuoi inserire?");
		quantit‡Moneta = in.nextInt();
		contaDieciCent += quantit‡Moneta;
		valoreTotaleInserito += quantit‡Moneta * 0.1;

		saldoCassa += valoreTotaleInserito;
		Disegno.StampaStringa("La cassa Ë stata ricaricata di " + valoreTotaleInserito + " Ä");
		Disegno.StampaStringa("Il nuovo saldoCassa Ë di " + saldoCassa + " Ä");

	}

	@Override
	public void caricaProdotto() {
		distributore.clear();
		distributore = new HashMap<Integer, ArrayList>();
		for (int i = 1; i <= 9; i++) {
			distributore.put(i, new ArrayList());

		}

		for (int i = 0; i < 10; i++) {

			distributore.get(1).add(new AcquaM());
			distributore.get(2).add(new Sprite());
			distributore.get(3).add(new CocaCola());
			distributore.get(4).add(new Crostino());
			distributore.get(5).add(new Sticks());
			distributore.get(6).add(new Tramezzino());
			distributore.get(7).add(new Kbueno());
			distributore.get(8).add(new Mars());
			distributore.get(9).add(new Bounty());

		}
		Disegno.StampaStringa("Prodotti caricati");
	}

	@Override
	public void stampaResoconto() {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"C:\\Users\\Utente\\eclipse-workspace\\DistributoreAutomatico\\bin\\Resoconto1.txt"));
			bw.write("Resoconto vendite:\nSono stati venduti " + contaProdottoVenduto
					+ " prodotti, per un incasso pari a: " + guadagnoCassa + " euro.\n\nDettaglio:\n");
			for (int j = 0; j < listaVendite.size(); j++) {

				bw.write("- " + listaVendite.get(j));
				bw.newLine();
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		Disegno.StampaStringa("Stampa resoconto vendita...");
		Disegno.StampaStringa("Recuperare il file nel path:");
		Disegno.StampaStringa("C:\\Users\\Utente\\eclipse-workspace\\DistributoreAutomatico\\bin\\Resoconto1.txt");
	}
}
