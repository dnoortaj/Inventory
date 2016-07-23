
public class Game
{
	private String name;
	private int numCopies;
	private int idNum;
	private String type;
	
	Game(String name, int numCopies, int idNum, String type)
	{
		this.name = name;
		this.numCopies = numCopies;
		this.idNum = idNum;
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumCopies()
	{
		return numCopies;
	}

	public void setNumCopies(int numCopies)
	{
		this.numCopies = numCopies;
	}

	public int getIdNum()
	{
		return idNum;
	}

	public void setIdNum(int idNum)
	{
		this.idNum = idNum;
	}
	
	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
	public String toString()
	{
		return ("ID: " + idNum + "  Name: " + name + "  Copies Available: " + numCopies + "  Game Type: " + type);
	}
	
	public String toFile()
	{
		return (name + "\n" + numCopies + "\n" + idNum + "\n" + type);
	}

}
