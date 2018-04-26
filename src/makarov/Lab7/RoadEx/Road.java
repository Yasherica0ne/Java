package makarov.Lab7.RoadEx;

public class Road
{
	public static boolean isIsRoadClear()
	{
		return isRoadClear;
	}

	private static boolean isRoadClear = true;
	private static long carCounter = 0;
	private static long leftSideCarsCount = 0;
	private static long rightSideCarsCount = 0;
	private static boolean carsMoveSide;
	private static Road road = new Road();
	private static boolean isFirstCar = true;

	public static Road getRoad()
	{
		return road;
	}

	private static synchronized void PrintRoad()
	{
		System.out.println("Машин слева: " + leftSideCarsCount + ", машин справа: " + rightSideCarsCount);
	}

	public static synchronized boolean tryDrive(boolean Side)
	{
		if(isFirstCar)
		{
			carsMoveSide = Side;
			isFirstCar = false;
		}
		if (carsMoveSide == Side && carCounter < 3 && isRoadClear)
		{
			PrintRoad();
			carCounter++;
			if(!Side) rightSideCarsCount++;
			else leftSideCarsCount++;
			if (carCounter == 3)
			{
				isRoadClear = false;
				carsMoveSide = !carsMoveSide;
			}
			return true;
		}
		return false;
	}

	public static synchronized void DriveEnd(boolean side)
	{
		carCounter--;
		if(!side) rightSideCarsCount--;
		else leftSideCarsCount--;
		if (carCounter == 0)
		{
			isRoadClear = true;
		}
	}
}
