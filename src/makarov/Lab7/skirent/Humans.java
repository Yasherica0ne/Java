package makarov.Lab7.skirent;

import javax.swing.text.ChangedCharSetException;
import java.util.Random;

public class Humans extends Thread
{
	private static int CLIENTS_COUNT = 0;
	private boolean isWait = false;

	private int humansNumber;
	private boolean isPensioner;

	public int getNumber()
	{
		return humansNumber;
	}

	public boolean isPensioner()
	{
		return isPensioner;
	}

	public Humans()
	{
		humansNumber = CLIENTS_COUNT++;
		if (CLIENTS_COUNT > 6 && CLIENTS_COUNT < 10)
		{
			isPensioner = true;
		}
		else isPensioner = false;
	}

	private void changeClientState(String state)
	{
		System.out.println("Клиент №" + this.getNumber() + (this.isPensioner() ? " (пенсионер) " : " ") + state);
	}

	@Override
	public void run()
	{
		Random rand = new Random();
		SkiRent.printSkisCount();
		int waitingTime = rand.nextInt(8000) + 8000;
		changeClientState("пришёл за лыжами");
		while (true)
		{
			try
			{
				if (SkiRent.checkPriority(this))
				{
					if (SkiRent.getSemaphore().tryAcquire())
					{
						SkiRent.deleteHuman(this);
						SkiRent.tryTakeSkis();
						changeClientState("берёт лыжи");
						SkiRent.printSkisCount();
						Thread.sleep(waitingTime);
						SkiRent.giveBackSki();
						changeClientState("возвращает лыжи");
						SkiRent.getSemaphore().release();
						break;
					}
				}
				else if(!isWait)
				{
					isWait = true;
					changeClientState("ждёт своей очереди");
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
