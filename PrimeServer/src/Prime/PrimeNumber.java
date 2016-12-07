package Prime;


import util.NumberToText;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {


	// Schrittweite bei der Berechnung der Primzahlen
	public static int STEP_SIZE = 1000;

	// ArrayList Cache
	private ArrayList<Boolean> primeCache;
	// number of primes in the ArrayList
	private int numOfPrimes;
	private int lastCheckedNumber;

	public PrimeNumber() {
		primeCache = new ArrayList<Boolean>();
		primeCache.add(0, false);
		primeCache.add(1, false);
		lastCheckedNumber = 2;
		numOfPrimes = 0;
	}

	public List<Integer> getPrimeInterger(int max)
	{
		return getFirstNPrimes(max);
	}

	public String getPrimeString(int max)
	{
		return parseToString(getFirstNPrimes(max));
	}

	public List<PrimeObject> getPrimeObjects(int max)
	{
		return parseToPrimeObjects(getFirstNPrimes(max));
	}

	public String getPrimeStringNumber(int max)
	{
		return parseToStringNumber(getFirstNPrimes(max));
	}



	/**
	 *  This method parses a list of integers to a string of numbers ("1 2 3")
	 * @param list
	 * @return
	 */

	private String parseToStringNumber(List<Integer> list)
	{
		StringBuffer buffer = new StringBuffer();

		for (Integer integer : list)
		{
			buffer.append(integer).append(" ");

		}
		return buffer.toString();
	}

	/**
	 *  This method parses a list of integers to a list  of PrimeObjects
	 * @return
	 */
	private List<PrimeObject> parseToPrimeObjects(List<Integer> primes )
	{
		List<PrimeObject> primeObjects = new ArrayList<>();
		for (Integer prime : primes)
		{
			primeObjects.add(new PrimeObject(prime));
		}

		return primeObjects;
	}




	/**
	 *  This method parses a list of integers to words ("eins zwei drei")
	 * @param list
	 * @return
	 */
	private String parseToString(List<Integer> list)
	{
		StringBuffer buffer = new StringBuffer();

		for (Integer integer : list)
		{
			buffer.append(NumberToText.intToText(integer)).append("\n");


		}
		return buffer.toString();
	}




	/**
	 * berechne die ersten n Primzahlen
	 *
	 * @param n
	 *            Anzahl der Primzahlen
	 * @return Liste der ersten n Primzahlen
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getFirstNPrimes(Integer n) {

		ArrayList<Boolean> localPrimeCache;
		int localLastCheckedNumber;
		int localNumOfPrimes;


		synchronized (this) {
			// prüfe, ob der Request mit dem globalen Cache beantwortet werden kann
			if (n <= numOfPrimes) {
				return getResultList(n);
			}

			// wenn nicht erstelle lokale Kopien
			localPrimeCache = (ArrayList<Boolean>) primeCache.clone();
			localLastCheckedNumber = lastCheckedNumber;
			localNumOfPrimes = numOfPrimes;
		}


		// berechne Primzahlen in der lokalen Cache Kopie
		while (localNumOfPrimes < n) {

			int intervalEndIndex = localLastCheckedNumber + STEP_SIZE;

			// Sieb des Eratosthenes
			for (int numberToCheck = localLastCheckedNumber; numberToCheck < intervalEndIndex; numberToCheck++) {
				// alle Zahlen werden zunächst als Primzahl betrachtet
				localPrimeCache.add(numberToCheck, true);

				// sortiere alle Primzahlen aus, welche durch eine Zahl zwischen
				// 2 und Wurzel(intervalEnd) (ausgenommen sich selbst) teilbar
				// sind
				int limit = (int) Math.sqrt(intervalEndIndex);
				for (int x = 2; x < limit; x++) {
					if (localPrimeCache.get(numberToCheck) && (numberToCheck % x == 0) && (numberToCheck != x)) {
						localPrimeCache.set(numberToCheck, false);
					}
				}
			}

			// zähle alle verbleibenden Primzahlen im lokalen Cache
			for (int i = localLastCheckedNumber; i < intervalEndIndex; i++) {
				if (localPrimeCache.get(i)) {
					localNumOfPrimes++;
				}
			}

			// update localLastCheckedNumber auf das neue Intervall Ende
			localLastCheckedNumber = intervalEndIndex;
		}

		// tausche lokalen Cache mit dem globalen Cache, wenn die lokalePrimanzahl > der globalen
		synchronized (this) {
			if (localNumOfPrimes > numOfPrimes) {
				numOfPrimes = localNumOfPrimes;
				lastCheckedNumber = localLastCheckedNumber;
				primeCache = localPrimeCache;
			}
		}

		return getResultList(n);
	}

	/**
	 * Gibt eine Liste der ersten n Primzahlen zurück, dabei muss n <= mit der
	 * Anzahl der Primzahlen in primCache
	 *
	 * @param n
	 * @return
	 */
	private synchronized List<Integer> getResultList(int n) {
		ArrayList<Integer> primeResultList = new ArrayList<>();
		// Kopiere die Werte in die Liste und gib sie zurück
		for (int i = 0; i < lastCheckedNumber; i++) {
			if (primeCache.get(i)) {
				primeResultList.add(i);
			}
			if (primeResultList.size() == n) {
				return primeResultList;
			}
		}
		return primeResultList;
	}

	/**
	 * this method returns a list of primes by a given limit
	 * @param max
	 * @return
	 */
	private List<Integer> calcPrimebyMax(int max)
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
