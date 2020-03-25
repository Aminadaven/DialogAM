package attacks;

public class AttacksVector {
	private Attack[] vector;
	public AttacksVector() {
		vector = new Attack[0];
	}
	public void add(Attack atk) {
		Attack[] temp = new Attack[vector.length + 1];
		for(int i = 0; i < vector.length; i++) {
			temp[i] = vector[i];
		}
		temp[temp.length - 1] = atk;
		vector = new Attack[temp.length];
		for(int i = 0; i < vector.length; i++) {
			vector[i] = temp[i];
		}
	}
	public Attack get(int num) {
		return vector[num];
	}
	public Attack[] getAll() {
		return vector;
	}
	public int getSize() {
		return vector.length;
	}
	public void remove(int num) {
		Attack[] temp = new Attack[vector.length - 1];
		int i;
		for(i = 0; i < temp.length && i < num; i++) {
			temp[i] = vector[i];
		}
		for( ; i < temp.length; i++) {
			temp[i] = vector[i + 1];
		}
		vector = new Attack[temp.length];
		for(i = 0; i < vector.length; i++) {
			vector[i] = temp[i];
		}
	}
	public boolean hasAttack(Attack attack) {
		for(int i = 0; i < vector.length; i++) {
			if(vector[i].name.equals(attack.name)) return true;
		}
		return false;
	}
}