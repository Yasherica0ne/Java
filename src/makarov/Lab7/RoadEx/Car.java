package makarov.Lab7.RoadEx;

import java.util.Random;

public class Car extends Thread
{
	private long carNumber;
	private static long carsCounter = 0;
	private boolean moveSide;

	public Car()
	{
		this.carNumber = carsCounter++;
		this.moveSide = new Random().nextBoolean();
	}

	private void printStatus(String status)
	{
		System.out.println("Машина №" + this.carNumber + " " + status);
	}

	@Override
	public void run()
	{
		Random random = new Random();
		while (true)
		{
		synchronized (Road.getRoad())
		{
			if (!Road.isIsRoadClear())
			{
				try
				{
					printStatus("ждёт");
					Road.getRoad().wait(random.nextInt(6000) + 6000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		if (Road.tryDrive(this.moveSide))
		{
			printStatus("едет " + (this.moveSide ? "вправо" : "влево"));
			try
			{
				Thread.sleep(random.nextInt(3000) + 3000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			Road.DriveEnd(this.moveSide);
			printStatus("проехал");
			synchronized (Road.getRoad())
			{
				Road.getRoad().notify();
			}
			break;
			}
		}
	}
}
