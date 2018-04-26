package makarov.Lab7.Canteen;
import java.util.Random;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		final int studCount = 20;
		Random random = new Random();
		for (int i = 0; i < studCount; i++)
		{
			(new Student()).start();
			Thread.sleep(random.nextInt(1500) + 500);
		}
	}
}
