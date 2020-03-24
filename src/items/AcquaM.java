package items;

import utils.Item;

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
	public float DammiPrezzo() {
		// TODO Auto-generated method stub
		return 0.50f;
	}

}
