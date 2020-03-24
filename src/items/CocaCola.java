package items;

import utils.Item;

public class CocaCola implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "CocaCola";
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
