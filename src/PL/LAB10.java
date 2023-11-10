package PL;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LAB10 implements ActionListener {
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
		addPoem = new JButton("Add Poem");
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
		//add poem task by Faraz Maqsood
		if (command.equals("POEM")) {
			String filePath = "poem.txt";
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
				String line;
				JFrame frame = new JFrame();
				JTable table = new JTable();
				JScrollPane scrollPane = new JScrollPane(table);
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Poem Verses");
				while ((line = br.readLine()) != null) {
					model.addRow(new Object[] { line });
				}
				table.setModel(model);

		        frame.add(scrollPane);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.pack();
		        frame.setVisible(true);
			} catch (IOException ex) {

			}
		} else if (command.equals("VERSE")) {
			System.out.println("VERSE");
		} else if (command.equals("ROOT")) {
			System.out.println("ROOT");
		}
	}

	public static void main(String[] args) {
		LAB10 lab10 = new LAB10();
	}
}
