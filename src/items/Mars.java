package items;

import utils.Item;

public class Mars implements Item {

	@Override
	public String DammiNome() {
		return "Mars";
	}

	@Override
	public float DammiPrezzo() {
		return 1.10f;
	}

	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,10 euro.";
	}
}
