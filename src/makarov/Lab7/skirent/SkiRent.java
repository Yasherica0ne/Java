package makarov.Lab7.skirent;

import java.util.concurrent.*;

public class SkiRent
{
	private static final int skisCount = 5;

	public static int getFreePlaces()
	{
		return freeSkis;
	}


	public static SkiRent getSkiRent()
	{
		if (skiRent != null)
			return skiRent;
		else
			return skiRent = new SkiRent();
	}

	private static SkiRent skiRent;
	private static int freeSkis = skisCount;

	public static Semaphore getSemaphore()
	{
		return semaphore;
	}

	private static Semaphore semaphore = new Semaphore(skisCount, true);

	private static CopyOnWriteArrayList<Integer> simpleQueue = new CopyOnWriteArrayList<>();
	private static CopyOnWriteArrayList<Integer> pensionerQueue = new CopyOnWriteArrayList<>();

	public static void printSkisCount()

	{
		System.out.println("Лыж свободно " + freeSkis);
	}

	public static boolean checkPriority(Humans human)
	{
		if (human.isPensioner())
		{
			if (pensionerQueue.get(0).equals(human.getNumber())) return true;
			else return false;
		}
		else if (pensionerQueue.isEmpty())
		{
			if (simpleQueue.get(0).equals(human.getNumber())) return true;
			else return false;
		}
		else return false;
		/*if (simpleQueue.get(0) == clientsPriority) return true;
		else return false;*/
	}

	public static void addClients(Humans human) throws InterruptedException
	{
		if (human.isPensioner())
		{
			pensionerQueue.add(human.getNumber());
		}
		else
		{
			simpleQueue.add(human.getNumber());
		}
		/*if (!simpleQueue.isEmpty())
		{
			if (human.getClient().isPensioner())
			{
				if (simpleQueue.get(0).isPensioner())
				{
					for (int i = 0; i < simpleQueue.size(); i++)
					{
						if (!simpleQueue.get(i).isPensioner())
						{
							simpleQueue.add(i - 1, human.getClient());
							break;
						}
					}
					return;
				}
			}
		}
		simpleQueue.add(human.getClient());*/
		return;
	}

	public static void deleteHuman(Humans human) throws InterruptedException
	{
		if (human.isPensioner())
		{
			pensionerQueue.remove((Integer)human.getNumber());
		}
		else
		{
			simpleQueue.remove((Integer)human.getNumber());
		}
		//simpleQueue.remove(clientsPriority);
	}

	public static boolean tryTakeSkis()
	{
		if (freeSkis > 0)
		{
			freeSkis--;
			return true;
		}
		else
		{
			System.out.println("Свободные лыжи закончились");
			return false;
		}
	}

	public static void giveBackSki()
	{
		if (freeSkis < skisCount) freeSkis++;
	}
}
