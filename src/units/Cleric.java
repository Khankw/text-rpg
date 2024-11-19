package units;

import java.util.ArrayList;

public class Cleric extends Playable {

	public Cleric(String name) {
		super(name, 120, 40, 20, 30);
	}

	@Override
	public boolean useSkill(ArrayList<Unit> units) {
		// TODO Auto-generated method stub
		return false;
	}

}
