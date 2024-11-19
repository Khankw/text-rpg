package units;

import java.util.ArrayList;

import framework.RandomGen;

abstract public class Unit {
	private String name;
	protected int maxHp;
	protected int hp;
	protected int maxSp;
	protected int sp;
	protected int power;
	protected int attack;
	protected int bonusAttack;
	protected int defense;
	protected int bonusDefense;
	protected int speed;
	protected int turn;

	protected RandomGen ran = RandomGen.getInstance();

	public Unit(String name, int hp, int sp, int power, int speed) {
		this.name = name;
		this.hp = hp + ran.get(0, 100);
		this.maxHp = this.hp;
		this.sp = sp + ran.get(0, 50);
		this.maxSp = this.sp;
		this.power = power + ran.get(0, 10);
		this.attack = this.power;
		this.speed = speed + ran.get(0, 10);
	}

	public String getName() {
		return name;
	}

	public void setBonus(int attack, int defense) {
		bonusAttack = attack;
		bonusDefense = defense;
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
		damage -= ran.get(defense / 2, defense) + bonusDefense;
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
		if (hp > maxHp)
			hp = maxHp;
	}

	public void attack(Unit unit) {
		int damage = ran.get(attack / 2, attack) + bonusAttack;
		unit.takeDamage(damage);
	}

	abstract public boolean useSkill(ArrayList<Unit> units);

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(name).append(" [직업:").append(this.getClass().getSimpleName());
		str.append("]\n[HP:").append(hp).append("/").append(maxHp);
		str.append("][SP:").append(sp).append("/").append(maxSp);
		str.append("][공격력:").append(attack).append("][방어력:").append(defense);
		str.append("]");
		return str.toString();
	}
}
