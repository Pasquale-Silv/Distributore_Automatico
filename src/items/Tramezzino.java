package items;

import utils.Item;

public class Tramezzino implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Tramezzino";
	}

	@Override
	public float DammiPrezzo() {
		// TODO Auto-generated method stub
		return 1.80f;
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,80 euro.";
	}
}
