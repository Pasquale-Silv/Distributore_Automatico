package it.items;

import java.math.BigDecimal;

import it.utils.Item;

public class Bounty implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Bounty";
	}

	@Override
	public BigDecimal DammiPrezzo() {
		// TODO Auto-generated method stub
		return new BigDecimal("0.20");
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,20 euro.";
	}
}
