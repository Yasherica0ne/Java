package makarov.Lab7.skirent;

import java.util.Random;

public class SkiRentMain
{
	public static void main(String[] args) throws Exception
	{
		final int humansCount = 20;
		Random random = new Random();
		//SkiRent.getSkiRent();
		for (int i = 0; i < humansCount; i++)
		{
			Humans humans = new Humans();
			SkiRent.addClients(humans);
			humans.start();
			Thread.sleep(random.nextInt(1500) + 500);
		}
	}
}
