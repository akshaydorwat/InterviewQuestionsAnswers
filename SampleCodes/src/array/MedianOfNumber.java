package array;

public class MedianOfNumber {
	int arr1[];
	int arr2[];
	
	int median( int arr[], int start, int n)
	{
		if(n % 2 == 0)
		{
			return (arr[(start+n)/2] + arr[(start+n)/2 - 1])/2;
		}
		else
		{
			return arr[(start+n)/2];
		}
	}
	
	int  getMedian(int start1, int start2, int n)
	{
		int m1,m2;
		
		if(n < 0)
		{
			return -1;
		}
		
		if(n == 1)
		{
			return (arr1[start1] + arr2[start2])/2;
		}
		
		if(n == 2)
		{
			return max(arr1[start1] , arr2[start2]) + min(arr1[start1+1] , arr2[start2+1])/2;
		}
		
		m1 = median(arr1,start1,n);
		m2 = median(arr2,start2, n);
		
		if(m1 == m2)
		{
			return m1;
		}
		
		if(m1 > m2)
		{
			if(n%2 == 0)
			{
				return getMedian(start1, start2+n/2-1, n-n/2+1);
			}
			else
			{
				return getMedian(start1, start2+n/2, n-n/2);
			}	
		}
		else
		{
			if(n%2 == 0)
			{
				return getMedian(start1+n/2-1, start2, n-n/2+1);
			}
			else
			{
				return getMedian(start1+n/2, start2, n-n/2);
			}	
		}	
		
	}
	
	int max(int x,int y)
	{
		return (x>y) ? x : y;
	}
	
	int min(int x, int y)
	{
		return (x>y) ? y : x;
	}
	
	public static void main(String[] args) {
		MedianOfNumber m = new MedianOfNumber();
		m.arr1 = new int[]{1,11,21,31};
		m.arr2 = new int[]{2,12,22,32};
		System.out.println(m.getMedian(0, 0, m.arr1.length));
		
	}
	
}
