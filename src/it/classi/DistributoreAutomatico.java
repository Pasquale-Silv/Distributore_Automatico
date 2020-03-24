/**
 * 
 */
package it.classi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import it.items.AcquaM;
import it.items.Bounty;
import it.items.CocaCola;
import it.items.Crostino;
import it.items.Kbueno;
import it.items.Mars;

import it.items.Sprite;
import it.items.Sticks;
import it.items.Tramezzino;
import it.utils.Distributore;
import it.utils.Item;
import it.utils.Monete;

public class DistributoreAutomatico implements Distributore, Monete {
	private static final String PASSWORDAMMINISTRATORE = "Admin";
	private static int contaDueEuro = 0;
	private static int contaUnEuro = 0;
	private static int contaCinquantaCent = 0;
	private static int contaVentiCent = 0;
	private static int contaDieciCent = 0;
	private BigDecimal restoCheManca = BigDecimal.ZERO;
	private BigDecimal resto = BigDecimal.ZERO;
	private BigDecimal restoConCassaZero = BigDecimal.ZERO;
	// private static float resto;
	private static boolean isOn;
	private static ArrayList<String> listaVendite = new ArrayList<String>();
	private BigDecimal valoreTotaleInserito = BigDecimal.ZERO;
	private BigDecimal zero = BigDecimal.ZERO;
	private static BigDecimal saldoCassa = BigDecimal.ZERO;
	// private static float saldoCassa;
	private static int contaProdottoVenduto;
	private BigDecimal guadagnoCassa = BigDecimal.ZERO;
	// private static float guadagnoCassa;
	Scanner in = new Scanner(System.in);
	private BigDecimal raggiungiImporto = BigDecimal.ZERO;
	// private float raggiungiImporto = 0.00f;
	private BigDecimal quantoManca = BigDecimal.ZERO;
	// private float quantoManca = 0.00f;
	private DecimalFormat df = new DecimalFormat();
	private BigDecimal dieci = new BigDecimal(0.10);
	private BigDecimal venti = new BigDecimal(0.20);
	private BigDecimal cinquanta = new BigDecimal(0.50);
	private BigDecimal valoreDueEuro = BigDecimal.ZERO;
	private BigDecimal valoreUnEuro = BigDecimal.ZERO;
	private BigDecimal valoreCinquantaCent = BigDecimal.ZERO;
	private BigDecimal valoreVentiCent = BigDecimal.ZERO;
	private BigDecimal valoreDieciCent = BigDecimal.ZERO;

	public static HashMap<Integer, ArrayList> distributore = new HashMap<Integer, ArrayList>();

	public static String getPasswordamministratore() {
		return PASSWORDAMMINISTRATORE;
	}

	@Override
	public void accendiSpegni() {
		if (!isOn) {
			isOn = true;
			Disegno.StampaStringa("Il distributore Ë acceso.");
		} else {
			/*
			 * if (isOn) { isOn = false;
			 */
			isOn = false;
			Disegno.StampaStringa("Spegnimento in corso.....");
			// }
		}

	}

	public static boolean isOn() {
		return isOn;
	}

	@Override
	public BigDecimal calcolaResto() {
		int cont = 0;

		resto = raggiungiImporto.subtract(quantoManca); // - quantoManca;
		restoConCassaZero = raggiungiImporto.subtract(quantoManca);
		do {
			cont++;
			while (resto.doubleValue() >= 2.00 && contaDueEuro > 0) {
				Disegno.StampaStringa("" + DUEEURO);
				resto = resto.subtract(DUEEURO);// - DUEEURO;
				contaDueEuro--;
			}
			while (resto.doubleValue() >= 1.00 && contaUnEuro > 0) {
				Disegno.StampaStringa("" + UNEURO);
				resto = resto.subtract(UNEURO);
				contaUnEuro--;
			}
			while (resto.doubleValue() >= 0.50 && contaCinquantaCent > 0) {
				Disegno.StampaStringa("" + CINQUANTACENT);
				resto = resto.subtract(CINQUANTACENT);
				contaCinquantaCent--;
			}
			while (resto.doubleValue() >= 0.20 && contaVentiCent > 0) {
				Disegno.StampaStringa("" + VENTICENT);
				resto = resto.subtract(VENTICENT);
				contaVentiCent--;
			}
			while (resto.doubleValue() >= 0.10 && contaDieciCent > 0)

			{
				Disegno.StampaStringa("" + DIECICENT);

				resto = resto.subtract(DIECICENT);
				contaDieciCent--;
			}

		} while (cont != 20);
		saldoCassa = saldoCassa.subtract(resto);
		if (saldoCassa.compareTo(saldoCassa.subtract(resto)) == -1) {
			Disegno.StampaStringa("Non Ë possibile erogare completamente il resto.");

		} else if (resto.compareTo(restoConCassaZero) == 0) {
			
			Disegno.StampaStringa("Nessun resto erogabile!!!");

		} else {
			
			Disegno.StampaStringa("Ritirare il resto...");
		}
		
		return resto;

	}

	@Override
	public void acquista() {
		boolean controlloScelta = false;
		int scelta = 0;
		if (!isOn) {
			System.out.println("Il distributore Ë spento...");
		} else {
			String sceltaDisegno = " ";
			Disegno.StampaMacchinetta(sceltaDisegno);
			System.out.println();
			System.out.println();
			Disegno.StampaApeChiDisplay(80);

			do {
				if (saldoCassa.doubleValue() < 2 && contaDieciCent < 1 || contaVentiCent < 1 || contaCinquantaCent < 1
						|| contaUnEuro < 1) {
					Disegno.StampaStringa("ATTENZIONE!!");
					Disegno.StampaStringa("Il distributore potrebbe non avere il resto necessario!!!");
				}
				Disegno.StampaStringaNotCap("Scegliere un prodotto dal distributore:");

				String Stringscelta = in.next();
				try {
					scelta = new Integer(Stringscelta);
				} catch (NumberFormatException e) {

					Disegno.StampaStringa("Non puoi inserire caratteri");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}

				if (scelta < 1 || scelta > 9) {
					Disegno.StampaStringa("Scelta non valida...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					controlloScelta = true;
				} else {
					if (distributore.isEmpty() || distributore.get(scelta).isEmpty()) {
						Disegno.StampaStringa("Il prodotto selezionato non Ë disponibile.");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						controlloScelta = true;
					} else {
						controlloScelta = false;
					}
				}

			} while (controlloScelta);
			Disegno.StampaApeChiDisplay(80);
			Disegno.StampaStringa("Inserire: " + ((Item) distributore.get(scelta).get(0)).DammiPrezzo() + "Ä");

			quantoManca = ((Item) distributore.get(scelta).get(0)).DammiPrezzo();

			do {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Disegno.StampaStringa("Digitare " + "A" + " per inserire 2Ä");
				Disegno.StampaStringa("Digitare " + "B" + " per inserire 1Ä");
				Disegno.StampaStringa("Digitare " + "C" + " per inserire 0,50 Ä");
				Disegno.StampaStringa("Digitare " + "D" + " per inserire 0,20 Ä ");
				Disegno.StampaStringaNotCap("Digitare " + "E" + " per inserire 0,10 Ä");
				String sceltaMonete = in.next();
				switch (sceltaMonete.toUpperCase()) {
				case "A":
					raggiungiImporto = raggiungiImporto.add(DUEEURO);
					contaDueEuro++;
					break;
				case "B":
					raggiungiImporto = raggiungiImporto.add(UNEURO); // 1.00f;
					contaUnEuro++;
					break;
				case "C":
					raggiungiImporto = raggiungiImporto.add(CINQUANTACENT); // 0.50f;
					contaCinquantaCent++;
					break;
				case "D":
					raggiungiImporto = raggiungiImporto.add(VENTICENT);
					contaVentiCent++;
					break;
				case "E":
					raggiungiImporto = raggiungiImporto.add(DIECICENT);
					contaDieciCent++;
					break;

				default:
					Disegno.StampaStringa("");
					Disegno.StampaStringa("ATTENZIONE!!!!Moneta non accettata!!!");
					break;
				}
				restoCheManca = quantoManca.subtract(raggiungiImporto);
				if (restoCheManca.compareTo(BigDecimal.ZERO) == 1) {
					Disegno.StampaStringa("");
					Disegno.StampaStringa("Devi inserire ancora: " + df.format(restoCheManca) + " Ä");
					Disegno.StampaStringa("");
				}
				Disegno.StampaStringa("");
			} while (!(raggiungiImporto.compareTo(quantoManca) == 0 || raggiungiImporto.compareTo(quantoManca) > 0));

			saldoCassa = saldoCassa.add(raggiungiImporto);
			guadagnoCassa = guadagnoCassa.add(quantoManca);
			contaProdottoVenduto++;

			Disegno.StampaStringaNotCap("Erogazione prodotto...");
			System.out.println();
			sceltaDisegno = ((Item) distributore.get(scelta).get(0)).DammiNome();

			DateTimeFormatter time = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm");
			String formattata = LocalDateTime.now().format(time);
			String nomeProdotto = ((Item) distributore.get(scelta).get(0)).toString();
			String datoVendita = formattata + "\t" + nomeProdotto;
			listaVendite.add(datoVendita);
			distributore.get(scelta).remove(0);

			if (raggiungiImporto.compareTo(quantoManca) > 0) {

				calcolaResto();
				Disegno.StampaStringa("Arrivederci");
				raggiungiImporto = zero;
			} else {
				raggiungiImporto = zero;
				Disegno.StampaStringa("Arrivederci");
			}
			try {
				Disegno.StampaApeChiDisplay(80);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println();
			Disegno.StampaMacchinetta(sceltaDisegno);
			System.out.println();
		}

	}

	@Override
	public BigDecimal svuotaCassa() {
		if (saldoCassa.compareTo(BigDecimal.ZERO) == 1) {
			Disegno.StampaStringa("Dalla cassa sono stati prelevati " + saldoCassa.doubleValue() + "Ä");
			Disegno.StampaApeChiDisplay(80);
			saldoCassa = new BigDecimal("0.00");
		} else {
			Disegno.StampaStringa("La cassa Ë vuota!");
		}
		return saldoCassa;
	}

	@Override
	public void ricaricaCassa() {

		Disegno.StampaApeChiDisplay(80);
		Disegno.StampaStringaNotCap("Quante monete da 2Ä vuoi inserire?");
		String stringquantit‡Moneta = in.next();
		try {
			Double quantit‡Moneta = new Double(stringquantit‡Moneta);
			BigDecimal qtaMoneta = new BigDecimal(quantit‡Moneta);
			contaDueEuro += quantit‡Moneta;
			valoreDueEuro = valoreDueEuro.add(qtaMoneta).multiply(DUEEURO);
			Disegno.StampaStringaNotCap("Quante monete da 1Ä vuoi inserire?");
			stringquantit‡Moneta = in.next();
			quantit‡Moneta = new Double(stringquantit‡Moneta);
			qtaMoneta = new BigDecimal(quantit‡Moneta);
			contaUnEuro += quantit‡Moneta;
			valoreUnEuro = valoreUnEuro.add(qtaMoneta).multiply(UNEURO);
			Disegno.StampaStringaNotCap("Quante monete da 0.50Ä vuoi inserire?");
			stringquantit‡Moneta = in.next();
			quantit‡Moneta = new Double(stringquantit‡Moneta);
			qtaMoneta = new BigDecimal(quantit‡Moneta);
			contaCinquantaCent += quantit‡Moneta;
			valoreCinquantaCent = valoreCinquantaCent.add(qtaMoneta).multiply(CINQUANTACENT);
			Disegno.StampaStringaNotCap("Quante monete da 0.20Ä vuoi inserire?");
			stringquantit‡Moneta = in.next();
			quantit‡Moneta = new Double(stringquantit‡Moneta);
			qtaMoneta = new BigDecimal(quantit‡Moneta);
			contaVentiCent += quantit‡Moneta;
			valoreVentiCent = valoreVentiCent.add(qtaMoneta).multiply(VENTICENT);
			Disegno.StampaStringaNotCap("Quante monete da 0.10Ä  vuoi inserire?");
			stringquantit‡Moneta = in.next();
			quantit‡Moneta = new Double(stringquantit‡Moneta);
			qtaMoneta = new BigDecimal(quantit‡Moneta);
			contaDieciCent += quantit‡Moneta;
			valoreDieciCent = valoreDieciCent.add(qtaMoneta).multiply(DIECICENT);
		} catch (NumberFormatException e) {
			Disegno.StampaStringa("Puoi Inserire solo numeri interi");
		}
		valoreTotaleInserito = valoreTotaleInserito.add(valoreDueEuro);
		valoreTotaleInserito = valoreTotaleInserito.add(valoreUnEuro);
		valoreTotaleInserito = valoreTotaleInserito.add(valoreCinquantaCent);
		valoreTotaleInserito = valoreTotaleInserito.add(valoreVentiCent);
		valoreTotaleInserito = valoreTotaleInserito.add(valoreDieciCent);
		df.setMaximumFractionDigits(2);
		saldoCassa = saldoCassa.add(valoreTotaleInserito);
		Disegno.StampaStringa("La cassa Ë stata ricaricata di " + df.format(valoreTotaleInserito) + " Ä");
		Disegno.StampaStringa("Il nuovo saldoCassa Ë di " + df.format(saldoCassa) + " Ä");

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
			distributore.get(5).add(new Tramezzino());
			distributore.get(6).add(new Sticks());
			distributore.get(7).add(new Kbueno());
			distributore.get(8).add(new Mars());
			distributore.get(9).add(new Bounty());

		}
		Disegno.StampaStringa("Prodotti caricati");
	}

	@Override
	public void stampaResoconto() {

		if (contaProdottoVenduto > 0) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						"C:\\Users\\Utente\\eclipse-workspace\\DistributoreAutomatico\\src\\Resoconto\\Resoconto.txt"));
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
			Disegno.StampaApeChiDisplay(80);
			System.out.println(
					"C:\\Users\\Utente\\eclipse-workspace\\DistributoreAutomatico\\src\\Resoconto\\Resoconto.txt");

		}

		else {
			Disegno.StampaStringa("Nessun prodotto venduto! Impossibile stampare il resoconto.");
			Disegno.StampaApeChiDisplay(80);
		}
	}
}
