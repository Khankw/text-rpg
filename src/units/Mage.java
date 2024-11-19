package units;

import java.util.ArrayList;

public class Mage extends Playable {

	public Mage(String name) {
		super(name, 100, 60, 40, 20);
	}

	@Override
	public boolean useSkill(ArrayList<Unit> units) {
		// TODO Auto-generated method stub
		return false;
	}

}
