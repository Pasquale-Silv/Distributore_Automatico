package it.classe.base;

public class Disegno {
	
	private static final char SPAZIO = ' ';
	private static final char TRATTINO = '—';
	private static final String title = "Distributore Automatico";
	private static final String title2 = "BottleNeck_©";
	private static final String title3 = "Team";
	
	
	
	
	static String[] componenti = { "AcquaM", "Sprite", "CocaCola", "Crostini", "Tramezzino", "Sticks", "KBueno", "Mars",
			"Bounty" };
	static int [] codici = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private static int spazi = 0;
	private static int maxParola;
	private static int maxMacchinetta;
	static int lunghezzaMaxDisplay;
	private static int Indice = 1;

	
	
	
	public static void StampaApeChiDisplay(int lunghezzaMax) {
		lunghezzaMaxDisplay=lunghezzaMax;
		System.out.print("|"+TRATTINO);
		for(int x=0;x<lunghezzaMax;x++)
		{
			System.out.print(TRATTINO);
		}
		System.out.println(TRATTINO+"|");
	}
	
	public static void StampaStringa(String stringa) {
		int lunghezza=stringa.length();
		System.out.print("| ");
		System.out.print(stringa);
		for(int x=0;x<lunghezzaMaxDisplay-lunghezza;x++)
		{
			System.out.print(SPAZIO);
		}
		System.out.println(" |");
		
		}
	
	
	
	public static void StampaMacchinetta(String scelta) {
		Indice = 1;
		TrovaParola();
		System.out.println();
		TitoloCentrato();
		System.out.println();
		stampaTrattini();
		System.out.println();
		stampDispTast();
		
		
		System.out.println();
		stampaTrattini();
		for (int c = 1; c < 4; c++) {
			System.out.println();
			stampaRiferimento(c, "codici");
			System.out.println();
			resetIndice();
			stampaRiferimento(c, componenti);
			System.out.println();
			resetIndice();
			stampaRiferimento(c, "quantita");
			System.out.println();
			stampaTrattini();
		}
		for (int d = 1; d < 3; d++) {
			System.out.println();
			stampaRiferimentoScelta(d,scelta);
			}
		System.out.println();
		stampaTrattini();
		
	}

	private static void stampaRiferimento(int c, String[] lel) {
		for (; Indice <= c * 3; Indice++) {
			
				spazi = maxParola - lel[Indice - 1].length();
			System.out.print("|  ");
			if (spazi % 2 != 0) {
				System.out.print(SPAZIO);
			}
			for (int d = 0; d < spazi / 2; d++) {
				System.out.print(SPAZIO);
			}
			System.out.print(lel[Indice - 1]);
			for (int d = 0; d < spazi / 2; d++) {
				System.out.print(SPAZIO);
			}
			System.out.print("  |");
		}
	}

	private static void stampaRiferimento(int c, String x) {

		for (; Indice <= c * 3; Indice++) {
			
			spazi = maxParola - 6;

			System.out.print("|  ");
			if (spazi % 2 != 0) {
				System.out.print(SPAZIO);
			}
			for (int d = 0; d < (spazi / 2); d++) {
				System.out.print(SPAZIO);
			}
			
			if (x.equals("codici"))
				System.out.print("Cod: "+codici[Indice-1]);
			else {
			System.out.print("Qty:");	
			ControlloQty(Indice);
			}
			for (int d = 0; d < spazi / 2; d++) {
				System.out.print(SPAZIO);
			}
			System.out.print("  |");
		}
	}
	
	private static void stampDispTast() {
		System.out.print("|  ");
		System.out.print("|————————|");
		for(int x=0;x<maxMacchinetta-27;x++) {
			System.out.print(SPAZIO);
		}
		System.out.print("|A|B|C|D|E|");
		System.out.println("  |");
		System.out.print("|  ");
		System.out.print("|        |");
		for(int x=0;x<maxMacchinetta-24-title2.length();x++) {
			if (x== (maxMacchinetta-24-title2.length())/2)
				System.out.print(title2);
			else
			System.out.print(SPAZIO);
		}
		System.out.print("|1|2|3|");
		System.out.println("    |");
		System.out.print("|  ");
		System.out.print("|        |");
		for(int x=0;x<maxMacchinetta-24-title3.length();x++) {
			if (x== (maxMacchinetta-24-title3.length())/2)
				System.out.print(title3);
			else
			System.out.print(SPAZIO);
		}
		System.out.print("|4|5|6|");
		System.out.println(" €I |");
		System.out.print("|  ");
		System.out.print("|————————|");
		for(int x=0;x<maxMacchinetta-25;x++) {
			System.out.print(SPAZIO);
		}
		System.out.print("|7|8|9|");
		System.out.print("    |");
		
		
	}
	
	
	
	private static void stampaRiferimentoScelta(int x,String scelta){

		for (int c=0 ; c <= 2 ; c++) {
			spazi = maxParola+4;
			if(c==0) 
			System.out.print("|  ");
			
			if(x==1 && c==1) {
				for (int d = 0; d < spazi; d++) {
					System.out.print("_");
			}
			}
				else if(x==2 && c==1) {
				spazi=maxParola-scelta.length();
				System.out.print("| ");
				for (int d = 0; d < spazi/2; d++) {
					System.out.print(SPAZIO);
				}
				System.out.print(scelta);
				for (int d = 0; d < spazi/2; d++) {
					System.out.print(SPAZIO);
				}
				if (spazi % 2 != 0) {
					System.out.print(SPAZIO);
				}
				System.out.print(" |");
			}
			else {
			for (int d = 0; d < spazi; d++) {
				System.out.print(SPAZIO);
			}
			}
			if(c==2)
			System.out.print("  |");
			}
		}

	
	
	
	private static void TitoloCentrato() {
		int lunghezzaTitle = title.length();
		int h = 0;
		if (maxParola % 2 == 0) {
			h = 1;
		}
		for (int x = 0; x < ((maxMacchinetta / 2)) - (lunghezzaTitle / 2); x++) {
			if(x==0)
				System.out.print("|");
			else
			System.out.print(TRATTINO);
		}
		System.out.print(title);
		for (int x = 0; x < ((maxMacchinetta / 2)) - (lunghezzaTitle / 2) - h; x++) {
			if(x==(maxMacchinetta / 2) - (lunghezzaTitle / 2)-h-1)
				System.out.print("|");
			else
			System.out.print(TRATTINO);
		}

	}



	private static void TrovaParola() {
		maxParola = 0;
		for (int i = 0; i < componenti.length; i++) {

			if (componenti[i].length() > maxParola) {
				maxParola = componenti[i].length();
			}

		}
		maxMacchinetta = (maxParola + 6) * 3;
	}

	private static void ControlloQty(int x) {
		if (DistributoreAutomatico.distributore.get(x).size() == 0)
			System.out.print("--");
		else if (DistributoreAutomatico.distributore.get(x).size() < 10 && DistributoreAutomatico.distributore.get(x).size()> 0) {
			System.out.print("0");
		}
		if (DistributoreAutomatico.distributore.get(x).size() != 0) {
			System.out.print(DistributoreAutomatico.distributore.get(x).size());
		}
	}

	private static void resetIndice() {
		Indice -= 3;
	}

	private static void stampaTrattini() {
		for (int x = 0; x < maxMacchinetta; x++)
			if(x==0 || x==maxMacchinetta-1)
				System.out.print("|");
			else
			System.out.print(TRATTINO);

	}
	
}
	
