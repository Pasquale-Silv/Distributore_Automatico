package it.items;

import java.math.BigDecimal;

import it.utils.Item;

public class AcquaM implements Item {

	@Override
	public String toString() {
		return  DammiNome() + ", prezzo: 0,50 centesimi.";
	}

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "AcquaM";
	}

	@Override
	public BigDecimal DammiPrezzo() {
		// TODO Auto-generated method stub
		return new BigDecimal("0.50");
	}

}
