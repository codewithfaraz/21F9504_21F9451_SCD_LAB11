package PL;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AssignRootsPL {
    private JFrame frame;
    private JTextField verseTextField;
    private JTextField rootTextField1;
    private JTextField rootTextField2;
    private JTextField rootTextField3;
    public  JButton assignRootButton;
    public AssignRootsPL() {
    	initialize();
    }

    public void initialize() {
        frame = new JFrame();
       frame.setSize(400,400);
       frame.setLocation(150,10);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel verseLabel = new JLabel("Enter Verse:");
        panel.add(verseLabel);

        verseTextField = new JTextField(20);
        panel.add(verseTextField);

        JLabel rootLabel = new JLabel("Assigned Root:");
        panel.add(rootLabel);

        rootTextField1 = new JTextField(20);
        rootTextField1.setEditable(false);
        panel.add(rootTextField1);
        
        rootTextField2 = new JTextField(20);
        rootTextField2.setEditable(false);
        panel.add(rootTextField2);
        
        rootTextField3 = new JTextField(20);
        rootTextField3.setEditable(false);
        panel.add(rootTextField3);

        assignRootButton = new JButton("Assign Root");
        assignRootButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignRootsToVerse();
            }
        });
        panel.add(assignRootButton);
        frame.setVisible(true);
    }

    public void assignRootsToVerse() {
        String verseText = verseTextField.getText();
        String [] v;
        
        v=assignRootsToVerse(verseText);
        
      //  String assignedRoot = assignRootsToVerse(verseText);
        if(!v[0].isEmpty())
        rootTextField1.setText(v[0]);
        if(v[1]!=null)
        rootTextField2.setText(v[1]);
        if(v[2]!=null)
        rootTextField3.setText(v[2]);
    }

    public String[] assignRootsToVerse(String verse) {
        String[] words = verse.split(" ");
        return words;
    }
}
