import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NameGUI extends JFrame implements ActionListener
{
	JTextField nameEntry = new JTextField(20);
	ArrayList<Player> names;
	int i = 1;
	int ps;
	JLabel j;
	JButton next;
	JComboBox roleList;
	String[] roles = {"Werewolf", "Seer", "Bodyguard", "Villager", "PI", "Cupid", "Hunter", "Vampire"};
	ArrayList<String> roleAL = new ArrayList<String>();
	boolean readyToProceed = false;
	
	public NameGUI( int players)
	{
		names = new ArrayList<Player> (players);
		ps = players;
		for (int e = 0; e < roles.length; e++)
		{
			roleAL.add(roles[e]);
		}
		
		setLayout(new BorderLayout());

		nameEntry.addActionListener(this);

		next = new JButton(">>>");
		next.addActionListener(this);
		next.setActionCommand("right");
		
		JButton previous = new JButton("<<<");
		previous.addActionListener(this);
		previous.setActionCommand("left");
		
		roleList = new JComboBox(roles);
		roleList.setSelectedIndex(0);
		roleList.setActionCommand("role");
		roleList.addActionListener(this);

		
		JPanel top = new JPanel();
		JPanel bot = new JPanel();
		
		j = new JLabel("Player " + i + "'s name: ");
		top.add (j);
		top.add (nameEntry);

		bot.add(previous);
		bot.add(next);
		
		add(top, BorderLayout.NORTH);
		add (roleList, BorderLayout.CENTER);
		add(bot, BorderLayout.SOUTH);
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public boolean inPlayerList(Player p)
	{
		boolean result = false;
		for (Player a : names)
		{
			if (p.equals(a))
			{
				result = true;
			}
		}
		return result;
	}
	
	public boolean getReadyToProceed()
	{
		return readyToProceed;
	}

	public void actionPerformed(ActionEvent evt)
	{
		int c = nameEntry.getText().length();
		int d;
		
		if (evt.getActionCommand().equals("left"))
		{
			if (c != 0) // make sure a name has been entered
			{
				if (i != 1) // can't go left from very first index
				{
					Player p = new Player(nameEntry.getText(), (String) (roleList.getSelectedItem()));
					if (!inPlayerList(p))
					{
						names.add(p);
					}
						i--; // decrement i, we're going left
						j.setText("Player " + i + "'s name: "); // adjust name box accordingly
						nameEntry.setText(names.get(i-1).getName()); // get previous name
						d = roleAL.indexOf(names.get(i-1).getRole());
						roleList.setSelectedIndex(d);
						System.out.println(names);
						repaint();
					
				}
			}
		}
		else if (evt.getActionCommand().equals("right"))
		{
			if (c != 0)
			{
				i++;
				if (i != ps)
				{
					Player p = new Player(nameEntry.getText(), (String) (roleList.getSelectedItem()));
					
					if (!inPlayerList(p))
					{
						names.add(p);
					}
					if (names.size() < i) // new term
					{
							j.setText("Player " + i + "'s name: ");
							nameEntry.setText("");
							roleList.setSelectedIndex(0);
							repaint();
							System.out.println(names);
					}
					else
					{
						j.setText("Player " + i + "'s name: ");
						nameEntry.setText(names.get(i-1).getName());
						d = roleAL.indexOf(names.get(i-1).getRole());
						roleList.setSelectedIndex(d);
						repaint();
						System.out.println(names);
					}
				}
				else // now on last term
				{
					j.setText("Player " + i + "'s name: ");
					nameEntry.setText("");
					roleList.setSelectedIndex(0);
					next.setText("Go!");
					next.setActionCommand("Ready");
					repaint();
					System.out.println(names);
				}
			}
		}
		else if (evt.getActionCommand().equals("Ready"))
		{
			Player p = new Player(nameEntry.getText(), (String) (roleList.getSelectedItem()));
			
			if (!inPlayerList(p))
			{
				names.add(p);
			}
			System.out.println(names);
			readyToProceed = true;
			
		}
//		else if (evt.getActionCommand().equals("role") && c != 0)
//		{
//			JComboBox cb = (JComboBox) evt.getSource();
//			Player p = new Player(nameEntry.getText(), (String) (cb.getSelectedItem()));
//			System.out.println(names.contains(p));
//			if (!names.contains(p))
//			{
//				names.add(p);
//			}
//		}

	}
	ArrayList<Player> getNames()
	{
		return names;
	}
	
	
	public static void main(String[] args)
	{
		NameGUI g = new NameGUI ( 4);
		g.setLocation(540, 400);
		g.setSize(450, 200);
		g.setVisible(true);
	}

}
