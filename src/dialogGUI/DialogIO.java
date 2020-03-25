package dialogGUI;

import javax.swing.JOptionPane;

public class DialogIO {

	public DialogIO() {
	}

	public static void out(String text) {
		JOptionPane.showMessageDialog(null, text, "A plain message", JOptionPane.PLAIN_MESSAGE);
	}

	public static int ynChoice(String question, String title, String... options) {
		return JOptionPane.showOptionDialog(null, question, title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
	}

	public static String choice(String question, String title, String... options) {
		return (String) JOptionPane.showInputDialog(null, question, title, JOptionPane.PLAIN_MESSAGE, null, options,
				options[0]);
	}

	public static String getStr(String question, String title) {
		return (String) JOptionPane.showInputDialog(null, question, title, JOptionPane.PLAIN_MESSAGE, null, null, null);
	}

}