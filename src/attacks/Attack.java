package attacks;

public class Attack {
	public int actualPp, pp, power, acc, missiles;
	public String name, desc, type, effect;

	public Attack(String name, String desc, String type, String effect, int pp, int power, int acc, int missiles) {
		this.name = name;
		this.desc = desc;
		this.type = type;
		this.effect = effect;
		this.pp = pp;
		this.power = power;
		this.acc = acc;
		this.missiles = missiles;
		actualPp = pp / 1;
	}
}