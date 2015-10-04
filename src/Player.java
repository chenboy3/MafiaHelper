import java.util.ArrayList;


public class Player
{
	String name;
	String role;
	boolean alive = true;
	ArrayList<String> status = new ArrayList<String>(); //  alive, dead, banished, dead, 
	public Player(String s, String r) 
	{
		name = s;
		role = r;
	}
	String getName()
	{
		return name;
	}
	public String getRole()
	{
		return role;
	}
	public boolean isAlive()
	{
		return alive;
	}
	public void dead()
	{
		alive = false;
	}
	public ArrayList<String> getStatus()
	{
		return status;
	}
	public void addStatus(String a)
	{
		status.add(a);
	}
	public void removeStatus(String a)
	{
		status.remove(a);
	}
	
	public String toString()
	{
		return ("Name: " + name + ", Role: " + role);
	}
	
	public boolean equals(Player p)
	{
		return getName().equals(p.getName());
	}
	
}
