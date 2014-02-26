package sampleCodes;

/*
 * Given a book with several page numbers (# starting with 1), count the 
 * occurrences of each digit in all of its page numbers.
 */

import java.util.Arrays;

public class DigitCount
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int numOfPages = 33;
		String numOfPagesStr = Integer.toString(numOfPages);
		int numberLength = numOfPagesStr.length();

		int digit = 0;
		int place = 0;
		int[] digitCount = new int[10];
		Arrays.fill(digitCount, 0);
		int temp = numOfPages;
		int temp2 = 0;

		for (int i = 0; i < numberLength; i++)
		{
			digit = temp % ((int) Math.pow(10, i + 1));

			if (place == 0)
			{
				for (int j = 0; j < digit; j++)
				{
					temp2 = (j + 1) % 10;
					digitCount[temp2]++;
				}
			}
			else
			{
				digitCount[digit] += numOfPages % ((int) Math.pow(10, i));
				for (int j = 0; j < 10; j++)
				{
					temp2 = (j + 1) % 10;
					digitCount[temp2] += digit * ((int) Math.pow(10, place - 1));
				}
			}

			temp = temp / ((int) Math.pow(10, i + 1));
			place++;
		}
		System.out.println(Arrays.toString(digitCount));
	}
}
