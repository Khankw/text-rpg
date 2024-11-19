package units;

import java.util.ArrayList;

public class Warrior extends Playable {

	public Warrior(String name) {
		super(name, 150, 20, 30, 40);
	}

	@Override
	public boolean useSkill(ArrayList<Unit> units) {
		// TODO Auto-generated method stub
		return false;
	}
}
