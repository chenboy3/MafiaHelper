import java.util.ArrayList;


public class MafiaHelper
{
	static int players;
	int time = 0;
	static ArrayList<Player> playerList = new ArrayList<Player>();
	public MafiaHelper() 
	{
		
	}
	
	public int getPlayers() 
	{
		OpeningGUI g = new OpeningGUI("Test");
		g.setSize(400, 100);
		g.setVisible(true);
		while (!g.getReadyToProceed())
		{
			System.out.println(time++); // SKETCHY AF
		}
		g.dispose();
		return g.getPlayers();
	}
	
	public ArrayList<Player> getNames(int p) 
	{
		NameGUI n = new NameGUI(p);
		n.setSize(2000, 2000);
		n.setVisible(true);
		return new ArrayList<Player>();
	}
	
	public static void main (String[] args)
	{
		MafiaHelper m = new MafiaHelper();
		players = m.getPlayers();
		playerList = m.getNames(players);
		
	}
}
