package units;

public class Cleric extends Playable {

	public Cleric(String name) {
		super(name, 120, 40, 20, 30);
	}

	@Override
	public boolean useSkill(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

}
