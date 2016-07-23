
public class ConsoleGame extends Game
{
	private String platform;
	private String platformVersion;
	
	ConsoleGame(String name, int numCopies, int idNum, String type, String platform, String platformVersion)
	{
		super(name, numCopies, idNum, type);
		this.platform = platform;
		this.platformVersion = platformVersion;
	}

	public String getPlatform()
	{
		return platform;
	}

	public void setPlatform(String platform)
	{
		this.platform = platform;
	}

	public String getPlatformVersion()
	{
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion)
	{
		this.platformVersion = platformVersion;
	}
	
	@Override
	public String toFile()
	{
		return (super.toFile() + "\n" + platform + "\n" + platformVersion);
	}

}
