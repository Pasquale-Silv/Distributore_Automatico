package it.items;

import java.math.BigDecimal;

import it.utils.Item;

public class Crostino implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Crostino";
	}

	@Override
	public BigDecimal DammiPrezzo() {
		// TODO Auto-generated method stub
		return new BigDecimal("1.00");
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1 euro.";
	}
}
