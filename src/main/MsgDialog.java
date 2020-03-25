package main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MsgDialog {
	
	static JDialog dial = new JDialog();
	static String state = "";
	
	/*
	public MsgDialog() {
		//JOptionPane.showInternalMessageDialog(gui.ioPanel, text, title+" - Story", JOptionPane.PLAIN_MESSAGE);
	}
	*/
	
	synchronized public static void msg(String msg, String title) {
		state = "output";
		dial.setTitle(title);
		JTextArea text = new JTextArea(msg);
		text.setEditable(false);
		text.setBackground(dial.getBackground());
		JPanel bPanel = new JPanel();
		JButton ok = new JButton("OK");
		ok.addActionListener(new Listener());
		bPanel.setSize(ok.getWidth(), ok.getWidth());
		bPanel.add(ok);
		dial.add(text);
		dial.add(bPanel);
		dial.setLayout(new GridLayout(2, 1));
		dial.pack();
		dial.setVisible(true);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dial.requestFocusInWindow();
	}
	
	synchronized public static void msgp(Container panel, String msg, String title) {
		state = "output";
		JInternalFrame frame = new JInternalFrame();
		frame.setTitle(title);
		JTextArea text = new JTextArea(msg);
		text.setEditable(false);
		text.setBackground(frame.getBackground());
		JPanel bPanel = new JPanel();
		JButton ok = new JButton("OK");
		
		ok.addActionListener(new InternalListener());
		bPanel.setSize(ok.getWidth(), ok.getWidth());
		bPanel.add(ok);
		frame.add(text);
		frame.add(bPanel);
		frame.setLayout(new GridLayout(2, 1));
		frame.pack();
		panel.add(frame);
		frame.setClosable(true);
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		/*
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		frame.requestFocusInWindow();
		*/
	}
	
	synchronized public static String input(String msg, String title) {
		state = "input";
		Listener.clicked = false;
		dial.setTitle(title);
		JTextArea text = new JTextArea(msg);
		text.setEditable(false);
		text.setBackground(dial.getBackground());
		JPanel bPanel = new JPanel();
		JTextField tf = new JTextField(10);
		JButton ok = new JButton("OK");
		ok.addActionListener(new Listener());
		bPanel.setSize(ok.getWidth(), ok.getWidth());
		bPanel.add(tf);
		bPanel.add(ok);
		dial.add(text);
		dial.add(bPanel);
		dial.setLayout(new GridLayout(2, 1));
		dial.pack();
		dial.setVisible(true);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dial.requestFocusInWindow();
		
		while(!Listener.clicked);
		return tf.getText();
	}
	
	synchronized public static String inputp(Container panel, String msg, String title) {
		state = "input";
		InternalListener.clicked = false;
		JInternalFrame frame = new JInternalFrame();
		frame.setTitle(title);
		JTextArea text = new JTextArea(msg);
		text.setEditable(false);
		text.setBackground(frame.getBackground());
		JPanel bPanel = new JPanel();
		JTextField tf = new JTextField(10);
		JButton ok = new JButton("OK");
		
		ok.addActionListener(new InternalListener());
		bPanel.setSize(ok.getWidth(), ok.getWidth());
		bPanel.add(tf);
		bPanel.add(ok);
		frame.add(text);
		frame.add(bPanel);
		frame.setLayout(new GridLayout(3, 1));
		frame.pack();
		panel.add(frame);
		frame.setClosable(true);
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		/*
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		frame.requestFocusInWindow();
		*/
		
		while(!InternalListener.clicked);
		return tf.getText();
	}
	
	synchronized public static String input(String msg, String title, String... options) {
		state = "list";
		Listener.clicked = false;
		dial.setTitle(title);
		JTextArea text = new JTextArea(msg);
		text.setEditable(false);
		text.setBackground(dial.getBackground());
		JPanel bPanel = new JPanel();
		//JTextField tf = new JTextField(10);
		JList<String> l = new JList<String>();
		l.setListData(options);
		l.setModel(new DefaultListModel<String>());
		JButton ok = new JButton("OK");
		ok.addActionListener(new Listener());
		bPanel.setSize(ok.getWidth(), ok.getWidth());
		bPanel.add(l);
		bPanel.add(ok);
		dial.add(text);
		dial.add(bPanel);
		dial.setLayout(new GridLayout(2, 1));
		dial.pack();
		dial.setVisible(true);
		dial.setLocationRelativeTo(null);
		dial.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dial.requestFocusInWindow();
		
		while(!Listener.clicked);
		return (String) l.getSelectedValue();
	}
	
	synchronized public static String inputp(Container panel, String msg, String title, String... options) {
		state = "list";
		InternalListener.clicked = false;
		JInternalFrame frame = new JInternalFrame();
		frame.setTitle(title);
		JTextArea text = new JTextArea(msg);
		text.setEditable(false);
		text.setBackground(frame.getBackground());
		JPanel bPanel = new JPanel();
		//JTextField tf = new JTextField(10);
		JComboBox bx = new JComboBox();
		//bx.set
		//JList<String> l = new JList<String>();
		DefaultComboBoxModel<String> m = new DefaultComboBoxModel<String>();
		for(int i = 0; i < options.length; i++) {
			m.addElement(options[i]);
		}
		bx.setModel(m);
		//l.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//l.setLayoutOrientation(JList.VERTICAL_WRAP);
		//l.setListData(options);
		//l.setModel(m);
		JButton ok = new JButton("OK");
		
		ok.addActionListener(new InternalListener());
		bPanel.setSize(ok.getWidth(), ok.getWidth());
		bPanel.add(bx);
		bPanel.add(ok);
		frame.add(text);
		frame.add(bPanel);
		frame.setLayout(new GridLayout(3, 1));
		frame.pack();
		panel.add(frame);
		frame.setClosable(true);
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		/*
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		frame.requestFocusInWindow();
		*/
		while(!InternalListener.clicked);
		return options[bx.getSelectedIndex()];
	}
}

class Listener implements ActionListener{
	static boolean clicked = false;
	@Override
	synchronized public void actionPerformed(ActionEvent click) {
		MsgDialog.dial.dispose();
		if(MsgDialog.state.equals("input")) {
			clicked = true;
		}
	}
}

class InternalListener implements ActionListener{
	static boolean clicked = false;
	@Override
	synchronized public void actionPerformed(ActionEvent click) {
		JButton btn =(JButton) (click.getSource());
		JPanel p = (JPanel) (btn.getParent());
		JInternalFrame f = (JInternalFrame) (p.getRootPane().getParent());
		f.dispose();
		try {
			f.setClosed(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		f.doDefaultCloseAction();
		if(MsgDialog.state.equals("input") || MsgDialog.state.equals("list")) {
			clicked = true;
		}
		MsgDialog.state = "";
	}
}