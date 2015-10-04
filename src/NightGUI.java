import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NightGUI extends JFrame implements ActionListener
{
	boolean next = false;
	ArrayList<Player> players;
	ArrayList<String> roles;
	String[] player;
	JLabel werewolf = new JLabel("Who do the werewolves kill?");
	JLabel seer = new JLabel("Who does the seer inspect?");
	JLabel bodyguard = new JLabel("Who does the bodyguard protect?");
	//JLabel pi = new JLabel("Who does the PI inspect?");
	//JLabel cupid = new JLabel("Who does cupid make fall in love?");
	//JLabel hunter = new JLabel("Who does the hunter kill?");
	//JLabel vampire = new JLabel("Who does the vampire bite?");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
//	JPanel p4 = new JPanel();
//	JPanel p5 = new JPanel();
//	JPanel p6 = new JPanel();
//	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();

	
	JComboBox playerComboBox1;
	JComboBox playerComboBox2;
	JComboBox playerComboBox3;
//	JComboBox playerComboBox4;
//	JComboBox playerComboBox5;
//	JComboBox playerComboBox6;
//	JComboBox playerComboBox7;
	
	JButton submit;
	public NightGUI(ArrayList<Player> p)
	{
		players = p;
		roles = new ArrayList<String>();
		player = new String[players.size()];
		int index = 0;
		for (Player d: players)
		{
			if (!roles.contains(d.getRole()))
			{
				roles.add(d.getRole());
			}
			player[index] = d.getName();
			index++;
		}
		playerComboBox1 = new JComboBox(player);
		playerComboBox2 = new JComboBox(player);
		playerComboBox3 = new JComboBox(player);
//		playerComboBox4 = new JComboBox(player);
//		playerComboBox5 = new JComboBox(player);
//		playerComboBox6 = new JComboBox(player);
//		playerComboBox7 = new JComboBox(player);
		
		playerComboBox1.addActionListener(this);
		playerComboBox2.addActionListener(this);
		playerComboBox3.addActionListener(this);
//		playerComboBox4.addActionListener(this);
//		playerComboBox5.addActionListener(this);
//		playerComboBox6.addActionListener(this);
//		playerComboBox7.addActionListener(this);
		
		submit = new JButton ("Go!");
		submit.setSize(100, 50);
		submit.setActionCommand("submit");
		submit.addActionListener(this);
		
		p1.add(werewolf);
		p1.add(playerComboBox1);
		p2.add(seer);
		p2.add(playerComboBox2);
		p3.add(bodyguard);
		p3.add(playerComboBox3);
//		p4.add(pi);
//		p4.add(playerComboBox4);
//		p5.add(cupid);
//		p5.add(playerComboBox5);
//		p6.add(hunter);
//		p6.add(playerComboBox6);
//		p7.add(vampire);
//		p7.add(playerComboBox7);
		p8.add(submit);
		
		setLayout(new FlowLayout());
		add(p1);
		add(p2);
		add(p3);
//		add(p4);
//		add(p5);
//		add(p6);
//		add(p7);
		add(submit);
		
		System.out.println(roles);
		System.out.println(players);
	}
	
	public boolean roleAlive(String role)
	{
		boolean answer = false;
		for (Player a : players)
		{
			if (a.getRole().equals(role))
			{
				answer = true;
			}
		}
		return answer;
	}
	
	public boolean ready()
	{
		return next;
	}
	
	public ArrayList<Player> updatePlayers()
	{
		return players;
	}
	
	public void playerDead(String s)
	{
		for (Player p: players)
		{
			if (p.getName().equals(s))
			{
				players.remove(p);
				break;
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getActionCommand().equals("submit"))
		{
			String target = (String) playerComboBox1.getSelectedItem();
			String saved = (String) playerComboBox3.getSelectedItem();
			if (!target.equals(saved))
			{
				playerDead(target);
			}
			next = true;
		}
		
	}
	
	public static void main(String[] args)
	{
		Player p1 = new Player("Lauren", "Werewolf");
		Player p2 = new Player("Kenny", "Villager");
		Player p3 = new Player("Darin", "Bodyguard");
		Player p4 = new Player("Riley", "Villager");
		Player p5 = new Player("Derek", "Seer");
		Player p6 = new Player("Zac", "Werewolf");
		ArrayList<Player> test = new ArrayList<Player>();
		test.add(p1);
		test.add(p2);
		test.add(p3);
		test.add(p4);
		test.add(p5);
		test.add(p6);
		NightGUI n = new NightGUI(test);
		n.setSize(350, 800);
		n.setVisible(true);
	}

}
