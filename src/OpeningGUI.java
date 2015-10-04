import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OpeningGUI extends JFrame implements ActionListener
{
	int players;
	boolean readyToProceed = false;
	JTextField number = new JTextField(15);
	public OpeningGUI(String title)
	{
		super(title);
		JLabel label = new JLabel("How many players?");
		// JButton button1 = new JButton("1");

		JButton go = new JButton ("Go!");
		JButton quit = new JButton("Quit");

		setLayout(new FlowLayout());
		add(label);
		// add(button1);
		add(number);
		add(go);
		add(quit);

		// button1.setActionCommand("1");
		go.setActionCommand("Go!");
		quit.setActionCommand("Quit");

		// button1.addActionListener(this);
		number.addActionListener(this);
		go.addActionListener(this);
		quit.addActionListener(this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public boolean getReadyToProceed() 
	{
		return readyToProceed;
	}
	
	public int getPlayers()
	{
		return players;
	}

	public void actionPerformed(ActionEvent evt)
	{
		String s = evt.getActionCommand();
		if (!s.equals("Quit"))
		{
			players = Integer.parseInt(number.getText());
			if (players > 0) 
			{
				readyToProceed = true;
			}
		}
		else
		{
			System.exit(0);
		}
	}

	public static void main(String[] args)
	{
		OpeningGUI g = new OpeningGUI("Test");
		g.setSize(400, 100);
		g.setVisible(true);
	}
}
