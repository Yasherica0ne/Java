package makarov.Lab7.TenderEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Tender
{
	private ArrayList<Company> companies;
	private CyclicBarrier barrier;
	public final int BIDS_NUMBER = 5;
	private long companiesCount = 0;

	public Tender()
	{
		this.companies = new ArrayList<Company>();
		this.barrier = new CyclicBarrier(this.BIDS_NUMBER, new Runnable()
		{
			public void run()
			{
				if(companiesCount > 2)
				{
					Company winner = Tender.this.defineWinner();
					System.out.println("Заявка #" + winner.getBidId() + ", цена:" + winner.getPrice() + " победил!");
				}
				else System.out.println("Торги не прошли");
			}
		});
	}

	public CyclicBarrier getBarrier()
	{
		return barrier;
	}

	public boolean add(Company e)
	{
		companiesCount++;
		return companies.add(e);
	}

	public Company defineWinner()
	{
		return Collections.min(companies, new Comparator<Company>()
		{
			@Override
			public int compare(Company ob1, Company ob2)
			{
				return ob1.getPrice() - ob2.getPrice();
			}
		});
	}

}
