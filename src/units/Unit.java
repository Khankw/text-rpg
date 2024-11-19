package units;

abstract public class Unit {
	private String name;
	protected int maxHp;
	protected int hp;
	protected int maxSp;
	protected int sp;
	protected int power;
	protected int attack;
	protected int defense;
	protected int speed;
	protected int turn;

	public Unit(String name, int hp, int sp, int power, int speed) {
		this.name = name;
		this.maxHp = hp;
		this.hp = hp;
		this.maxSp = sp;
		this.sp = sp;
		this.power = power;
		this.attack = power;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void resetTurn() {
		turn = 0;
		sp = maxSp;
	}

	public int chkTurn() {
		turn %= 100;
		turn += speed;
		increaseSP();
		return turn;
	}

	public void increaseSP() {
		if (sp < maxSp)
			sp++;
	}

	public void takeDamage(int damage) {
		damage -= defense;
		if (damage < 0)
			damage = 0;
		hp -= damage;
		if (hp < 0)
			hp = 0;
	}

	public boolean isDie() {
		return hp == 0;
	}

	public void healing(int heal) {
		hp += heal;
	}

	public void resurrection() {
		hp = maxHp;
	}

	public void attack(Unit unit) {
		unit.takeDamage(power);
	}

	abstract public boolean useSkill(Unit unit);

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("[").append(name).append("][HP:").append(hp).append("/").append(maxHp);
		str.append("][SP:").append(sp).append("/").append(maxSp);
		str.append("][공격력:").append(attack).append("][방어력:").append(defense);
		str.append("]");

		return str.toString();
	}
}
