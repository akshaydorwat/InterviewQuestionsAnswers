package array;
/**
 * Given a sorted array of n integers that has been rotated an unknown number of
times, give an O(log n) algorithm that finds an element in the array. You may assume
that the array was originally sorted in increasing order.
EXAMPLE:
Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
Output: 8 (the index of 5 in the array)
 */
 
public class FindElementInRotatedArray {
	
	int number[];
	
	public FindElementInRotatedArray(int num[])
	{
		this.number = num;
	}
	
	public int Finder(int start, int end, int elementToFind)
	{
		int mid;
		
		System.out.println("start:"+start+ " "+"end:"+end);
		if(start > end)
		{
			return -1;
		}
		
		mid = (start+end)/2;
		System.out.println("mid : "+number[mid] + " " + elementToFind);
		if(number[mid] == elementToFind)
		{
			return mid;
		}
		
		if(number[start] < number[mid])
		{
			System.out.println("start is lesser than mid");
			if(elementToFind > number[mid])
			{
				return Finder(mid+1, end, elementToFind);
			}
			else if((elementToFind < number[mid])&&(elementToFind < number[start]))
			{
				return Finder(mid+1, end, elementToFind);
			}else
			{
				return Finder(start, mid-1, elementToFind);
			}
		}
		else
		{
			System.out.println("start is greater than mid");
			if(elementToFind > number[end])
			{
				return Finder(start, mid-1, elementToFind);
			}
			else if(elementToFind <= number[end])
			{
				return Finder(mid+1, end, elementToFind);
			}
				
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int num[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		FindElementInRotatedArray e = new FindElementInRotatedArray(num);
		System.out.println(e.Finder(0, (num.length-1), 14));
	}
}
