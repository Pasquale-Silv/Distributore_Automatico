package it.utils;

import java.math.BigDecimal;

public interface Distributore {
	
	public BigDecimal calcolaResto();

	public void acquista();

	public void accendiSpegni();

	public void stampaResoconto();

	public void ricaricaCassa();

	public void caricaProdotto();

	public BigDecimal svuotaCassa();
}
