
public class MobileGame extends Game
{
	private String deviceType;
	private String versionNum;
	
	MobileGame(String name, int numCopies, int idNum, String type, String deviceType, String versionNum)
	{
		super(name, numCopies, idNum, type);
		this.deviceType = deviceType;
		this.versionNum = versionNum;
	}

	public String getDeviceType()
	{
		return deviceType;
	}

	public void setDeviceType(String deviceType)
	{
		this.deviceType = deviceType;
	}
	
	public String getVersionNum()
	{
		return deviceType;
	}

	public void setVersionNum(String versionNum)
	{
		this.versionNum = versionNum;
	}
	
	@Override
	public String toFile()
	{
		return (super.toFile() + "\n" + deviceType + "\n" + versionNum);
	}

}
