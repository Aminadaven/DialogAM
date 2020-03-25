package saveAndLoad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFile {
	Vector groups;
	private Path name;
	static Charset charset = Charset.forName("UTF-8");

	public SaveFile(String name) {
		this.name = Paths.get(name);
		groups = new Vector();
	}

	public void addGroup(KeyGroup group) {
		groups.add(group);
	}

	public KeyGroup getGroup(int num) {
		return (KeyGroup) groups.get(num);
	}

	public KeyGroup getGroup(String groupName) {
		for (int num = 0; num < groups.getSize(); num++) {
			KeyGroup group = (KeyGroup) groups.get(num);
			if (group.name.equals(groupName))
				return group;
		}
		return null;
	}

	public void removeGroup(KeyGroup group) {
		groups.remove(group);
	}

	public int getSize() {
		return groups.getSize();
	}

	public void save() {
		try (BufferedWriter writer = Files.newBufferedWriter(name, charset)) {

			String s = "";
			for (int i = 0; i < groups.getSize(); i++) {
				KeyGroup group = (KeyGroup) groups.get(i);
				s += "GROUP " + group.name;
				for (int j = 0; j < group.keys.getSize(); j++) {
					s += "\nKEY " + group.getKey(j).name + " " + group.getKey(j).value;
				}
				s += "\nEND\n";
			}
			s = s.substring(0, s.length() - 1);
			writer.write(s, 0, s.length());
			// System.out.println("\nThe File has been written");
		} catch (IOException x) {
			System.err.format("IOException: %s%n\nWrite Error", x);
		}
	}

	public void load() {
		try (BufferedReader reader = Files.newBufferedReader(name, charset)) {
			groups = new Vector();
			KeyGroup group = null;
			String line = null;
			String[] brokenLine;
			while ((line = reader.readLine()) != null) {
				brokenLine = line.split(" ");
				switch (brokenLine[0]) {
				case "GROUP":
					group = new KeyGroup(brokenLine[1]);
					break;
				case "KEY":
					String value = "";
					for (int i = 2; i < brokenLine.length; i++) {
						value += brokenLine[i] + " ";
					}
					value = brokenLine.length >= 3 ? value.substring(0, value.length() - 1) : value;
					// value.trim();
					//System.out.println("LOAD: KEY name:" + brokenLine[1] + " value:" + value);
					group.addKey(brokenLine[1], value);
					break;
				case "END":
					groups.add(group);
					break;
				}
			}
			// System.out.println("KeyGroups Loaded!");
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}