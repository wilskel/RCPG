package rngcp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Chord_Panel extends JPanel {
	private JTextField key;
	private JLabel title, inputlabel, c1, c2, c3, c4, c5;
	
	public Chord_Panel()
	{
		title = new JLabel("CPG");
		c1 = new JLabel("--");
		c2 = new JLabel("--");
		c3 = new JLabel("--");
		c4 = new JLabel("--");
		c5 = new JLabel("--");
		inputlabel = new JLabel("Enter key: ");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		c1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		c2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		c3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		c4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		c5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		inputlabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		setPreferredSize(new Dimension(300, 75));
		setBackground(Color.yellow);
		
		key = new JTextField(2);
		key.addActionListener(new Listener());
		
		add(title);
		add(inputlabel);
		add(key);
		add(c1); add(c2); add(c3); add(c4); add(c5);
	}
	
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//Chord temp = new Chord("x", 0);
			String input = key.getText();
			int convInput = Chord.convertToNum(input);
			if (convInput != -1)
			{
				String[] prog = Chord.generateProg(convInput);
				c1.setText(key.getText());
				c2.setText(prog[0]);
				c3.setText(prog[1]);
				c4.setText(prog[2]);
				c5.setText(prog[3]);
			} else {
				return;
			}
		}
	}
}
