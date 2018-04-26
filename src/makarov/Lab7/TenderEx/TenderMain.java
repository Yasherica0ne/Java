package makarov.Lab7.TenderEx;

import java.util.Random;

public class TenderMain
{
	private int attemptsCount = 0;
	private static long companiesCount = 0;
	private int BIDS_NUMBER = 5;

	public static void main(String[] args)
	{
		Tender tender = new Tender();
		int startPrice = new Random().nextInt(600) + 400;
		for (int i = 0; i < tender.BIDS_NUMBER; i++)
		{
			Company thread = new Company(i, startPrice, tender.getBarrier());
			tender.add(thread);
			thread.start();
		}
	}
}
