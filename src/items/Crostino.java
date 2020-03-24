package items;

import utils.Item;

public class Crostino implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Crostino";
	}

	@Override
	public float DammiPrezzo() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1 euro.";
	}
}
