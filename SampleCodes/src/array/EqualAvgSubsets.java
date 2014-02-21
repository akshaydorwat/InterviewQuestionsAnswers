package array;

/*
 * Given an array of numbers (not necessarily in sorted order) 
 * find 2 subsets of equal size having same average.  
 */

import java.util.Arrays;

public class EqualAvgSubsets
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] nums = {1,9,7,8,4,5,10,6,2,3,11,12};
		
		if(nums.length%2!=0)
		{
			System.out.println("Cannot split the array into equal parts.");
			return;
		}
		
		int[] nums1 = new int[nums.length/2];
		int[] nums2 = new int[nums.length/2];
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for(int i=0; i<nums.length/4; i++)
		{
			nums1[i] = nums[i];
		}
		for(int i=3*(nums.length/4); i < nums.length; i++)
		{
			nums1[i-(nums.length/2)] = nums[i];
		}
		for(int i=nums.length/4; i<3*(nums.length/4); i++)
		{
			nums2[i - (nums.length/4)] = nums[i];
		}
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i < nums1.length; i++)
		{
			sum1+=nums1[i];
			sum2+=nums2[i];
		}
		
		System.out.printf("Subarray 1 sum = %d " , sum1);
		System.out.println(Arrays.toString(nums1));
		System.out.printf("Subarray 2 sum = %d " , sum2);
		System.out.println(Arrays.toString(nums2));
	}
}
