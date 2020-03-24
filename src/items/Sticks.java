package items;

import utils.Item;

public class Sticks implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Sticks";
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
