package it.items;

import java.math.BigDecimal;

import it.utils.Item;

public class Tramezzino implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Tramezzino";
	}

	@Override
	public BigDecimal DammiPrezzo() {
		// TODO Auto-generated method stub
		return new BigDecimal("1.80");
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,80 euro.";
	}
}
