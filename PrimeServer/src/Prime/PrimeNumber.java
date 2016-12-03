package Prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {


	public String getPrimeString(int max)
	{
		return parseToString(calcPrime(max));

	}

	
	public List<Integer> getPrimeInterger(int max)
	{
		return calcPrime(max);
	}

	private String parseToString(List<Integer> list)
	{
		StringBuffer buffer = new StringBuffer();

		for (Integer integer : list)
		{
			buffer.append(integer).append(" ");

		}
		return buffer.toString();
	}
	

	private List<Integer> calcPrime(int max)
	{
		List<Integer> temp = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		// intit Arraylist

		for (int i = 0; i <= max; i++)
		{
			temp.add(i, i);
		}

		for (int i = 2; i <= max; i++)
		{

			if (temp.get(i) != -1)
			{
				int j = i;
				do
				{
					j = j + i;
					if (j <= max)
					{
						// Ist die Zahl ein Vielfaches einer
						// Primzahl, dann wird sie mit false
						// markiert
						temp.set(j, -1);
					}
				} while (j <= max);
			}
		}
		for (Integer integer : temp)
		{
			if(integer  > 1)
			{
				list.add(integer);
			}

		}

		return list;
	}

}
