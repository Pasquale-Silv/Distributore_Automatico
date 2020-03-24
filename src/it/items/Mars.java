package it.items;

import java.math.BigDecimal;

import it.utils.Item;

public class Mars implements Item {

	@Override
	public String DammiNome() {
		return "Mars";
	}

	@Override
	public BigDecimal DammiPrezzo() {
		return new BigDecimal("1.10");
	}

	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,10 euro.";
	}
}
