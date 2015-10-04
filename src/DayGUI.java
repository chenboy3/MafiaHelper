import java.awt.BorderLayout;
import java.awt.Color;
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

public class DayGUI extends JFrame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public DayGUI (ArrayList <Player> players) {
		setSize(400, 100);
		int eligable;
		JLabel j;
		for (Player p:players) {
			j= new JLabel(p.getName() + "\t" + p.getRole() + p.getStatus().toString());
			if (!p.isAlive()){
				j.setForeground(Color.GRAY); 
			}
		}
	}
	
	public static void main(ArrayList <Player> players)
	{
		DayGUI g = new DayGUI(players);
		g.setSize(400, 100);
		g.setVisible(true);
	}
}
