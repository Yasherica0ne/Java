package makarov.Lab7.RoadEx;

import makarov.Lab7.Canteen.Student;

import java.util.Random;

public class RoadMain
{
	public static void main(String[] args) throws Exception
	{
		final int studCount = 20;
		Random random = new Random();
		for (int i = 0; i < studCount; i++)
		{
			(new Car()).start();
			Thread.sleep(random.nextInt(1500) + 500);
		}
	}
}
