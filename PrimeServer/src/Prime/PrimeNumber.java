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

	/**
	 * Wandelt die Liste von Integer-Werten in einen String um
	 * @param list
	 * @return
	 */
	private String parseToString(List<Integer> list)
	{
		StringBuffer buffer = new StringBuffer();

		for (Integer integer : list)
		{
			buffer.append(integer).append("\n");
		}
		return buffer.toString();
	}
	

	/**
	 * TODO: 
	 * sollte eigentlich die ersten "max" Primzahlen zurückgeben
	 * und nicht nur die Primzahlen im Intervall 0 < i < max
	 * @param max
	 * @return
	 */
	private List<Integer> calcPrime(int max)
	{
		List<Integer> temp = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		// init Arraylist

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
