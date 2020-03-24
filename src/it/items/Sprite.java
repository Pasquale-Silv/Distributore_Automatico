package it.items;

import java.math.BigDecimal;

import it.utils.Item;

public class Sprite implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Sprite";
	}

	@Override
	public BigDecimal DammiPrezzo() {
		// TODO Auto-generated method stub
		return new BigDecimal("1.20");
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,20 euro.";
	}
}
