package makarov.Lab7.Canteen;

import java.util.Random;

public class Student extends Thread
{
	private static long studCount = 0;
	private long studNumber;

	Student()
	{
		studNumber = studCount;
		System.out.println("Пришёл студент номер " + studCount++);
	}

	@Override
	public void run()
	{
		Random random = new Random();
		Canteen canteen = Canteen.getCanteen();
		while (true)
		{
			synchronized (canteen)
			{
				if (Canteen.getFreePlaces() == 0)
				{
					try
					{
						System.out.println("Студент №" + studNumber + " ждёт");
						canteen.wait(random.nextInt(6000) + 6000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			if (Canteen.trySetPlace())
			{
				System.out.println("Студент №" + studNumber + " занял место");
				Canteen.printCanteen();
				try
				{
					Thread.sleep(random.nextInt(6000) + 6000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				Canteen.leavePlace();
				System.out.println("Студент №" + studNumber + " ушёл");
				Canteen.printCanteen();
				synchronized (canteen)
				{
					canteen.notify();
				}
				break;
			}
		}
	}
}
