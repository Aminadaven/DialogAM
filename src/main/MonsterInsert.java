package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MonsterInsert {
	static Path in = Paths.get("data.txt");
	static Path out = Paths.get("CoreVault.java");
	static Charset charset = Charset.forName("UTF-8");
	public static void main(String[] args) {
		String[] bline, sets = new String[8];
		String s = "";
		try (BufferedReader reader = Files.newBufferedReader(in, charset)) {
			String line = null;
			int iN = 0, sN = 0;
			boolean mega = false;
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				// lNum++;
				bline = line.split("\t");
				if ((bline[0].trim().charAt(0) + "").matches("\\d")) {
					iN++;
					if (iN == 1) {
						sets[0] = bline[1];// pokemon name
						//System.out.println("pokemon name: " + sets[0]);
					} else {
						sets[2] = bline[1];
						sets[3] = bline[2];
						sets[4] = bline[3];
						sets[5] = bline[4];
						sets[6] = bline[5];
						sets[7] = bline[6];
						//System.out.println("pokemon stats: ");
						//for(int i = 2; i < 8; i++) System.out.print(sets[i] + ",");
						//System.out.println();
						if (!mega) {
							s += "Core " + sets[0].toUpperCase() + " = new Core(\"" + sets[0] + "\", \"" + sets[1]
									+ "\", null, \"lvl 16\", new int[] { " + sets[2] + ", " + sets[3] + ", " + sets[4]
									+ ", " + sets[5] + ", " + sets[6] + ", " + sets[7]
									+ " }, new String[] { \"Angry\" }, " + "new LvlAttack[] { null });\n";
							
						}
						iN = 0;
						sN = 0;
					}
				} else if ((bline[0].trim().charAt(0) + "").matches("\\w")) {
					sN++;
					/*
					if (bline[0].matches("Mega")) {
						mega = true;
						System.out.println("pokemon is mega");
						break;
					}
					if (mega && iN == 2) {
						System.out.println("Mega Clean");
						mega = false;
						iN = 0;
						sN = 0;
					}
					*/
					if (sN == 1) {
						sets[1] = bline[0];
						//System.out.println("pokemon type: " + bline[0]);
					}
					if (sN == 2) {
						sets[1] = "#" + sets[1] + "&" + bline[0];
						//System.out.println("pokemon type 1+2: " + sets[1]);
					}
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n\nRead Error", x);
		}
		
		try (BufferedWriter writer = Files.newBufferedWriter(out, charset)) {
			writer.write(s, 0, s.length());
			System.out.println("\nFile is written");
		} catch (IOException x) {
			System.err.format("IOException: %s%n\nWrite Error", x);
		}
		deleteMega();
	}
	static void deleteMega() {
		lineHeap heap = new lineHeap();
		//String s = "";
		String last = "";
		try (BufferedReader reader = Files.newBufferedReader(out, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println("2nd word "+line.split(" ")[1]);
				System.out.println("last "+last);
				if(!last.equals(line.split(" ")[1])) {
					System.out.println(line.split(" ")[1] + " != " + last);
					//s += ;
					heap.add(line + "\n");
				}
				last = line.split(" ")[1];
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n\nRead Error", x);
		}
		
		
		try (BufferedWriter writer = Files.newBufferedWriter(out, charset)) {
			String s = "";
			last = "null";
			String[] words;// = new String[10];
			while(heap.isEmpty()) {
				words = heap.get().split(" ");
				words[6] = " CoreVaults."+last+", ";
				for(int i = 0; i < words.length; i++) {
					s += words[i] + " ";
				}
				last = words[1];
				//s += heap.get();
			}
			writer.write(s, 0, s.length());
			System.out.println("\nFile is written");
		} catch (IOException x) {
			System.err.format("IOException: %s%n\nWrite Error", x);
		}
	}
}
class lineHeap {
	String[] heap;
	public lineHeap() {
		heap = new String[0];
	}
	void add(String str) {
		String[] temp = new String[heap.length + 1];
		//int i = 0;
		for(int i = 0; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		temp[temp.length - 1] = str;
		heap = new String[temp.length];
		for(int i = 0; i < heap.length; i++) {
			heap[i] = temp[i];
		}
	}
	boolean isEmpty() {
		return heap.length > 0;
	}
	String get() {
		String[] temp = new String[heap.length - 1];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = heap[i];
		}
		String str = heap[heap.length - 1];
		heap = new String[temp.length];
		for(int i = 0; i < heap.length; i++) {
			heap[i] = temp[i];
		}
		return str;
		
	}
}