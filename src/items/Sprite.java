package items;

import utils.Item;

public class Sprite implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Sprite";
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
