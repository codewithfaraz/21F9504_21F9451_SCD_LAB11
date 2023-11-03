package PL;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LAB10 implements ActionListener{
	JFrame frame;
	private JPanel c1, c2;
	private JButton addPoem, addVerse, addRoot;
	private Container contentPane;

	// public constructor
	public LAB10() {
		init();
	}

	// init function
	public void init() {
		frame = new JFrame("Arabic Qaseeda");
		frame.setSize(400, 400);
		frame.setLocation(150, 10);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();
		c1 = new JPanel();
		c1.setLayout(null);
		addPoem = new JButton("Manage Books");
		addVerse = new JButton("Add Verse");
		addRoot = new JButton("Add new root");
		c1.setBounds(0, 0, 200, 720);
		addPoem.setBounds(10, 10, 120, 40);
		addVerse.setBounds(10, 60, 120, 40);
		addRoot.setBounds(10, 110, 120, 40);
		c1.add(addPoem);
		c1.add(addRoot);
		c1.add(addVerse);
		contentPane.add(c1);
		addPoem.setActionCommand("POEM");
		addVerse.setActionCommand("VERSE");
		addRoot.setActionCommand("ROOT");
		addPoem.addActionListener(this);
		addVerse.addActionListener(this);
		addRoot.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("POEM")) {
			System.out.println("ADD POEM");
		}else if(command.equals("VERSE")) {
			System.out.println("VERSE");
		}else if(command.equals("ROOT")) {
			System.out.println("ROOT");
		}
	}

	public static void main(String[] args) {
		LAB10 lab10 = new LAB10();
	}
}
