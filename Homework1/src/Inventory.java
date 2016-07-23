import java.util.*;
import java.io.*;

public class Inventory {
	public ArrayList<Game> inventory = new ArrayList<Game>();
	PrintWriter pr = null;
	
	public void printInventory()
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			System.out.println(inventory.get(i));
		}
	}
	
	public Game searchById(int id)
	{
		Game item = null;
		
		for (Game temp : inventory)
		{
			if (temp.getIdNum() == id)
			{
				item = temp;
			}
		}
		return item;
	}
	
	public void addItem(Game item)
	{
		inventory.add(item);
	}
	
	public void addToInventory(Inventory myInventory)
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("What is the name of the game? " );
			String name = sc.nextLine();
			System.out.print("How many copies do you have available? ");
			int numCopies = Integer.parseInt(sc.nextLine());
			System.out.print("What is the 7 digit ID number? ");
			int id = Integer.parseInt(sc.nextLine());
			System.out.print("What category does " + name + " belong to? (PC, Console, Mobile) ");
			String type = sc.nextLine();
			
			if (type.equalsIgnoreCase("PC"))
			{
				System.out.print("What are the memory requirements for " + name + "? ");
				String memReq = sc.nextLine();
				System.out.print("What are the disk requirements for " + name + "? ");
				String diskReq = sc.nextLine();
				PCGame temp = new PCGame(name, numCopies, id, type, memReq, diskReq);
				myInventory.addItem(temp);
			}
			
			else if (type.equalsIgnoreCase("Console"))
			{
				System.out.print("What platform is " + name + " on? ");
				String platform = sc.nextLine();
				System.out.print("What version is this platform? ");
				String version = sc.nextLine();
				ConsoleGame temp = new ConsoleGame(name, numCopies, id, type, platform, version);
				myInventory.addItem(temp);
			}
			
			else if (type.equalsIgnoreCase("Mobile"))
			{
				System.out.print("What operating system is " + name + " on? ");
				String deviceType = sc.nextLine();
				System.out.print("What version is " + deviceType + "? ");
				String versionNum = sc.nextLine();
				MobileGame temp = new MobileGame(name, numCopies, id, type, deviceType, versionNum);
				myInventory.addItem(temp);
			}
			
			else
			{
				System.out.println("Unknown game type:" + type);
				addToInventory(myInventory);
			}
		} catch (NumberFormatException e)
		{
			System.out.println("Sorry, invalid input. Returning to main menu...");
		}
	}
	
	public void deleteFromInventory()
	{		
		Scanner sc = new Scanner(System.in);
		try
		{
	
			System.out.println("What is the ID number of the game you wish to delete? ");
			int id = Integer.parseInt(sc.nextLine());
			Game temp = searchById(id);
			
			System.out.println("Is " + temp.getName() + " the game you wish to delete?");
			String answer = sc.nextLine();
			
			
			if (answer.equalsIgnoreCase("yes"))
			{
				inventory.remove(temp);
			}
			else if (answer.equalsIgnoreCase("no"))
			{
				deleteFromInventory();
			}
			else
			{
				System.out.println("Sorry- answer does not match choices. Returning to menu...");
			}
		} catch (NumberFormatException e)
		{
			System.out.println("Sorry, invalid input. Please enter only digits 0-9.");
			deleteFromInventory();
		} catch (NullPointerException e)
		{
			System.out.println("Sorry, that ID does not exist in this inventory. Would you still like to delete a game?");
			String answer = sc.nextLine();
			if (answer.equalsIgnoreCase("yes"))
			{
				deleteFromInventory();
			}
			else 
			{
			}
		}
	}
		
	
	public void getDataFromFile(String fileName, Inventory myInventory)
	{
		Scanner sc = null;
		
		try
		{

			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File " + fileName + " not found.");
			
		}
		
		while (sc != null && sc.hasNext())
		{

			String name = sc.nextLine();
			int numCopies = Integer.parseInt(sc.nextLine());
			int id = Integer.parseInt(sc.nextLine());
			String type = sc.nextLine();

			
			if (type.equalsIgnoreCase("PC"))
			{
				String memReq = sc.nextLine();
				String diskReq = sc.nextLine();
				PCGame temp = new PCGame(name, numCopies, id, type, memReq, diskReq);
				myInventory.addItem(temp);
				
			}
			
			else if (type.equalsIgnoreCase("Console"))
			{
				String platform = sc.nextLine();
				String version = sc.nextLine();
				ConsoleGame temp = new ConsoleGame(name, numCopies, id, type, platform, version);
				myInventory.addItem(temp);

			}
			
			else if (type.equalsIgnoreCase("Mobile"))
			{
				String deviceType = sc.nextLine();
				String versionNum = sc.nextLine();
				MobileGame temp = new MobileGame(name, numCopies, id, type, deviceType, versionNum);
				myInventory.addItem(temp);
				
			}
			
			else
			{
				System.out.println("Unknown game type:" + type);
			}
		}
		
		
	}
	
	public void writeToFile()
	{
		try
		{
			pr = new PrintWriter("inventory.txt");
			
			for (Game game : inventory)
			{
				pr.println(game.toFile());
				
				
			}
			pr.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		Inventory myInventory = new Inventory();
		try
		{
			myInventory.getDataFromFile("inventory.txt", myInventory);
			
			boolean end = false;
			System.out.println("Welcome to Inventory Display!");
			
			while (end != true)
			{
				System.out.println();
				System.out.println("What would you like to do with this inventory?");
				System.out.println("	1. View Inventory");
				System.out.println("	2. Add to Inventory");
				System.out.println("	3. Delete from Inventory");
				System.out.println("	4. Search by ID");
				System.out.println("	5. Exit");
				
				int answer = Integer.parseInt(kb.nextLine());
				
				if (answer == 1)
				{
					myInventory.printInventory();
					
				}
				else if (answer == 2)
				{
					myInventory.addToInventory(myInventory);
				}
				else if (answer == 3)
				{
					myInventory.deleteFromInventory();
				}
				else if (answer == 4)
				{
					System.out.println("Please enter ID number of item");
					
					int id = Integer.parseInt(kb.nextLine());
					Game item = myInventory.searchById(id);
					 if (item != null)
			            {
			               System.out.println(item);
			            } 
					 else
			            {
			               System.out.println("Sorry- item not found in inventory");
			            }
				}
				else if (answer == 5)
				{
					end = true;
					myInventory.writeToFile();
				}
				else
				{
					System.out.println("I'm sorry, your answer did not match the options. \n Please try again.");
				}
			}
		} catch (NumberFormatException e)
		{
			System.out.println("Sorry, invalid input. Exiting...");
			myInventory.writeToFile();
			
		}
		
		
	}
	
	

}
