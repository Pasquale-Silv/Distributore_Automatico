package items;

import utils.Item;

public class Kbueno implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Kbueno";
	}

	@Override
	public float DammiPrezzo() {
		// TODO Auto-generated method stub
		return 1.20f;
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,20 euro.";
	}
}
