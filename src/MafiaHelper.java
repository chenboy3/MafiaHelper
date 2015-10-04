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
	
	public ArrayList<Player> night(ArrayList<Player> p) 
	{
		NightGUI night = new NightGUI(p);
		night.setSize(350, 500);
		night.setVisible(true);
		while(!night.ready())
		{
			System.out.println(time++);
		}
		night.dispose();
		return night.updatePlayers();
	}
	
	public static void main (String[] args)
	{
		MafiaHelper m = new MafiaHelper();
		players = m.getPlayers();
		playerList = m.getNames(players);
		System.out.println(m.night(playerList));
		
	}
}
