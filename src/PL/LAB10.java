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
	AssignRootsPL pl;

	// public constructor
	public LAB10() {
		pl = new AssignRootsPL();
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
		addVerse = new JButton("Assign Roots");
		addRoot = new JButton("Tokenize Verse");
		c1.setBounds(0, 0, 200, 720);
		addPoem.setBounds(10, 10, 150, 40);
		addVerse.setBounds(10, 60, 150, 40);
		addRoot.setBounds(10, 110, 150, 40);
		c1.add(addPoem);
		c1.add(addRoot);
		c1.add(addVerse);
		contentPane.add(c1);
		addPoem.setActionCommand("POEM");
		addVerse.setActionCommand("Assign");
		addRoot.setActionCommand("Token");
		addPoem.addActionListener(this);
		addVerse.addActionListener(this);
		addRoot.addActionListener(this);

		pl.assignRootButton.setActionCommand("Root");
		pl.assignRootButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		String filePath = "poem.txt";
		String line;
		JFrame frame;
		JTable table;
		JScrollPane scrollPane;
		DefaultTableModel model;
		//faraz
		if (command.equals("POEM")) {
			{
				try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {

					frame = new JFrame();
					table = new JTable();
					scrollPane = new JScrollPane(table);
					model = new DefaultTableModel();
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
			}
		} else if (command.equals("Assign")) {
			System.out.println("VERSE");
			pl.initialize();
			//faraz
		} else if (command.equals("Token")) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
				frame = new JFrame();
				table = new JTable();
				scrollPane = new JScrollPane(table);
				model = new DefaultTableModel();
				model.addColumn("Tokenized Verses");
				int count = 0;
				while ((line = br.readLine()) != null) {
					count++;
					String[] tokenizedVerse = line.split(" ");
					for (int i = 0; i < tokenizedVerse.length; i++) {
						model.addRow(new Object[] { tokenizedVerse[i] + "    V" + count });
					}
				}
				table.setModel(model);

				frame.add(scrollPane);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			} catch (IOException ex) {

			}
		}
	}

	public static void main(String[] args) {

		LAB10 lab10 = new LAB10();

	}
}
