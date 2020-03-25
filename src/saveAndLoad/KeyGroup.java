package saveAndLoad;

public class KeyGroup {
	class Key {
		String name, value;

		public Key(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	String name;
	Vector keys;

	public KeyGroup(String name) {
		this.name = name;
		keys = new Vector();
	}

	public void addKey(String name, String value) {
		keys.add(new Key(name, value));
	}

	public Key getKey(int num) {
		return (Key) keys.get(num);
	}

	public String getKey(String name) {
		for (int num = 0; num < keys.getSize(); num++) {
			Key key = (Key) keys.get(num);
			if (key.name.equals(name)) {
				//System.out.println("REQUEST:" + name + " KEY name:" + key.name + " value:" + key.value);
				return key.value;
			}
		}
		//System.out.println("GET KEY:" + name + " == null");
		return null;
	}

	public void removeKey(int num) {
		keys.remove(num);
	}
}