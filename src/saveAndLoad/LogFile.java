package saveAndLoad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogFile {
	Path name;
	static Charset charset = Charset.forName("UTF-8");
	
	public LogFile(String name) {
		this.name = Paths.get(name);
	}

	public void save(String text) {
		try (BufferedWriter writer = Files.newBufferedWriter(name, charset)) {
			writer.write(text);
		} catch (IOException x) {
			System.err.format("IOException: %s%n\nWrite Error", x);
		}
	}
	
	public String load() {
		String text = "";
		try (BufferedReader reader = Files.newBufferedReader(name, charset)) {
			String line;
			while ((line = reader.readLine()) != null) {
				text += line;
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return text;
	}
}