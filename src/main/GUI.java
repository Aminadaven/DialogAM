package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
	public JPanel playerPanel = new JPanel(), ioPanel = new JPanel(), mapPanel = new JPanel(), logPanel = new JPanel();
	JDesktopPane io = new JDesktopPane();
	JTextArea playerData = new JTextArea(10, 20), log = new JTextArea(10, 20);
	JButton ok = new JButton("OK");
	ImageIcon icon = new ImageIcon("Image1.png");
	JLabel iconCont = new JLabel(icon);
	//TableModel data = TableModel;
	//data[0][0] = icon;
	JTable map = new JTable();
	Dimension sizeBox = new Dimension(150, 350);
	DefaultListModel<String> model = new DefaultListModel<String>();
	JList<String> options = new JList<String>();
	JTextField input = new JTextField();
	//JTextArea log = new JTextArea();
	JScrollPane ps = new JScrollPane(playerData), ls = new JScrollPane(log);
	String recInput = "";
	boolean list = false;
	JDialog output = new JDialog();
	public GUI() {
		playerPanel.setSize(sizeBox);
		io.setSize(sizeBox);
		mapPanel.setSize(sizeBox);
		logPanel.setSize(sizeBox);

		playerPanel.setBorder(BorderFactory.createTitledBorder("Player Data"));
		io.setBorder(BorderFactory.createTitledBorder("Main Game"));
		mapPanel.setBorder(BorderFactory.createTitledBorder("Map"));
		logPanel.setBorder(BorderFactory.createTitledBorder("Log"));
		
		playerData.setEditable(false);
		playerPanel.add(ps);
		
		//output.
		
		/*
		output.setEditable(false);
		options.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//options.setVisible(false);
		//input.setVisible(false);
		ok.addActionListener(this);
		ioPanel.add(output);
		ioPanel.add(options);
		ioPanel.add(input);
		ioPanel.add(ok);
		*/
		
		//map.(icon);
		//mapPanel.add(iconCont);
		//mapPanel.add(map);
		
		log.setEditable(false);
		logPanel.add(ls);
		
		/*
		playerPanel.add(playerData);
		playerPanel.setBorder(BorderFactory.createTitledBorder("Player Data:"));
		playerPanel.setLayout(new FlowLayout());
		playerPanel.setSize(2000, 2000);

		ioPanel.setBorder(BorderFactory.createTitledBorder("Main Game"));
		ioPanel.setLayout(new FlowLayout());
		ioPanel.setSize(2000, 2000);
		*/

		add(playerPanel, BorderLayout.LINE_START);
		add(io, BorderLayout.CENTER);
		add(mapPanel, BorderLayout.LINE_END);
		add(logPanel, BorderLayout.PAGE_END);

		setSize(600, 1500);
		// this.setPreferredSize(new Dimension(5000, 5000));
		pack();
		//this.setLayout(new BorderLayout());
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("");
		this.setVisible(true);
		// aminadav.pack();
		// aminadav.setLayout(new BorderLayout());
		// aminadav.setResizable(false);
		// aminadav.setLocationRelativeTo(null);
		// aminadav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// aminadav.setTitle(title + ver + credit);
		// aminadav.setVisible(true);
	}

	/*
	public static void main(String[] args) {
		GUI x = new GUI();
		x.setData("a\na\na\na\na\na\na\na\n");
	}
	*/

	public void setData(String data) {
		playerData.setText(data);
	}

	public void log(String data) {
		log.setText(log.getText() +data+ "\n");
	}
	
	public void out(String str) {
		//output.setText(str);
	}
	
	public String in() {
		out("in()");
		list = false;
		options.setVisible(false);
		/*
		ioPanel.remove(ok);
		ioPanel.add(input);
		ioPanel.add(ok);
		*/
		input.setVisible(true);
		while(recInput.equals(""));
		String str = recInput;
		recInput = "";
		return str;
	}
	
	public String in(String... options) {
		out("in(String... options)");
		list = true;
		for(int i = 0; i < options.length; i++) {
			model.addElement(options[i]);
		}
		this.options.repaint();
		/*
		ioPanel.remove(ok);
		ioPanel.add(this.options);
		ioPanel.add(ok);
		*/
		this.options.setVisible(true);
		input.setVisible(false);
		while(recInput.equals(""));
		
		String str = recInput;
		recInput = "";
		return str;
	}

	public int choice(String title, String... options) {
		out(title);
		String choice = in(options);
		for (int num = 0; num < options.length; num++) {
			if (choice.equals(options[num]))
				return num;
		}
		return -1;
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		if(list) {
			recInput = options.getSelectedValue();
			model.clear();
			//options.setVisible(false);
			ioPanel.remove(options);
		}
		else {
			recInput = input.getText();
			input.setText("");
			//input.setVisible(false);
			ioPanel.remove(input);
		}
	}

	public String getLog() {
		return log.getText();
	}

	public void setLog(String txt) {
		log.setText(txt);
	}
}