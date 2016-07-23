
public class PCGame extends Game
{
	private String memRequirements;
	private String diskRequirements;
	
	PCGame(String name, int numCopies, int idNum, String type, String memRequirements, String diskRequirements)
	{
		super(name, numCopies, idNum, type);
		this.memRequirements = memRequirements;
		this.diskRequirements = diskRequirements;
	}

	public String getMemRequirements()
	{
		return memRequirements;
	}

	public void setMemRequirements(String memRequirements)
	{
		this.memRequirements = memRequirements;
	}

	public String getDiskRequirements()
	{
		return diskRequirements;
	}

	public void setDiskRequirements(String diskRequirements)
	{
		this.diskRequirements = diskRequirements;
	}
	
	@Override
	public String toFile()
	{
		return (super.toFile() + "\n" + memRequirements + "\n" + diskRequirements);
	}
	

}
