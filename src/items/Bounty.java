package items;

import utils.Item;

public class Bounty implements Item {

	@Override
	public String DammiNome() {
		// TODO Auto-generated method stub
		return "Bounty";
	}

	@Override
	public float DammiPrezzo() {
		// TODO Auto-generated method stub
		return 1.10f;
	}
	@Override
	public String toString() {
		return DammiNome() + ", prezzo: 1,10 euro.";
	}
}
