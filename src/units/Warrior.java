package units;

public class Warrior extends Playable {

	public Warrior(String name) {
		super(name, 150, 20, 30, 40);
	}

	@Override
	public boolean useSkill(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}
}
