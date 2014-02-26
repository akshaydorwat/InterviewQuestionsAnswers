package array;

/*
 * Given an array of 0's and 1's, rearrange them into alternating groups of
 * 0's and 1's such number of elements in each respective groups follow the pattern ...
 * sizeof_group[0] = 1
 * sizeof_group[1] = 2
 * sizeof_group[n] = (sizeof_group[n-1])^2 -(sizeof_group[n-2])^2 
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Rearrange
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] digits = { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1 };
		int end = digits.length - 1;
		ArrayList<Integer> fn = new ArrayList<Integer>();
		fn.add(1);
		fn.add(2);

		int gid = 0;
		int gval = 0;
		int gbound = 1;

		System.out.println(Arrays.toString(digits));

		for (int i = 0; i < digits.length && i < gbound; i++)
		{
			if (gid % 2 == 0)
			{
				if (digits[i] == 1)
				{
					for (int j = end; j > i; j--)
					{
						if (digits[j] == 0)
						{
							digits[i] = 0;
							digits[j] = 1;
							break;
						}
					}
				}
			}
			else
			{
				if (digits[i] == 0)
				{
					for (int j = end; j > i; j--)
					{
						if (digits[j] == 1)
						{
							digits[i] = 1;
							digits[j] = 0;
							break;
						}
					}
				}
			}

			if ((i == gbound - 1) && gbound < digits.length)
			{
				gid++;
				gval = fn.size() > gid ? fn.get(gid) : (fn.get(gid - 1) * fn.get(gid - 1)) - (fn.get(gid - 2) * fn.get(gid - 2));
				if (fn.size() == gid)
				{
					fn.add(gval);
				}
				gbound += gval;
			}
		}
		System.out.println(Arrays.toString(fn.toArray()));
		System.out.println(Arrays.toString(digits));
	}
}
