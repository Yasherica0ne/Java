package makarov.Lab7.Canteen;

public class Canteen
{
	public static int getFreePlaces()
	{
		return freePlaces;
	}

	private Canteen()
	{
		freePlaces = 5;
		placesCount = freePlaces;
	}

	public static Canteen getCanteen()
	{
		if (canteen != null)
			return canteen;
		else
			return canteen = new Canteen();
	}

	private static Canteen canteen;
	private static int freePlaces;
	private static int placesCount;

	public static void printCanteen()
	{
		System.out.println("Мест свободно " + freePlaces);
	}

	public static synchronized boolean trySetPlace()
	{
		if (freePlaces > 0)
		{
			freePlaces--;
			return true;
		}
		else
		{
			System.out.println("Свободные места закончились");
			return false;
		}
	}

	public static synchronized void leavePlace()
	{
		if (freePlaces < placesCount) freePlaces++;
	}
}
