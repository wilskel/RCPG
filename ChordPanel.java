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
public class ChordPanel extends JPanel {
	private JTextField key;
	private JLabel inputlabel, c1;
	
	public ChordPanel()
	{
		c1 = new JLabel("--, --, --, --, --");
		inputlabel = new JLabel("Enter tonic key: ");
		c1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		inputlabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		setPreferredSize(new Dimension(300, 100));
		setBackground(Color.white);
		
		key = new JTextField(2);
		key.addActionListener(new Listener());
		
		add(inputlabel);
		add(key);
		add(c1);
	}
	
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//Runs Functions from Chord and puts them in labels
			String input = key.getText();
			int convInput = Chord.convertToNum(input);
			if (convInput != -1)
			{
				String[] prog = Chord.generateProg(convInput);
				String labeltext = key.getText().toUpperCase() + ", " + prog[0] + ", " + prog[1] + ", " + prog[2] + ", " + prog[3];
				c1.setText(labeltext);
			} else {
				return;
			}
		}
	}
}
