package sampleCodes;

class MergeSort extends Sort{
	
	int temp[];

	public MergeSort(int[] numb) {
		super(numb);
		// TODO Auto-generated constructor stub
		temp = new int [numb.length];
	}
	
	private void merge( int start, int mid, int end)
	{
		int i = start;
		int j = mid + 1;
		int k = start;
		
		while(i <= mid && j <= end)
		{
			if(number[i] < number[j])
			{
				temp[k] = number[i];
				k++;
				i++;
			}
			else
			{
				temp[k] = number[j];
				k++;
				j++;
			}
		}
		
		while(i <= mid)
		{
			temp[k] = number[i];
			k++;
			i++;
		}
		
		while(j <= end)
		{
			temp[k] = number[j];
			k++;
			j++;
		}
		
		
		for(i=k-1; i >= start; i--)
		{
			number[i] = temp[i];
		}
	}
	
	public void mergeSort(int start, int end)
	{
		int mid;
		
		if(start<end)
		{
			mid = (start+ end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			merge(start, mid, end );
		}
	}
}

public class Sort {
	int number[];
	
	
	public Sort(int numb[]) {
		// TODO Auto-generated constructor stub
		this.number = numb;
	}
	
	
	
	protected void swap(int i, int j)
	{
		number[i] = number[i] ^ number[j];
		number[j] = number[i] ^ number[j];
		number[i] = number[i] ^ number[j];
	}
	
	private void maxHeap(int i)
	{
		int parent;
		
		if(i <= 0){
			return;
		}
		
		parent = (i-1)/2;
		
		if(number[parent] < number[i])
		{
			swap(parent, i);
		}
		
		maxHeap(parent);
	}
	
	private void buildHeap()
	{
		for(int i = 1; i<number.length; i++ )
		{
			maxHeap(i);
		}
	}
	
	public void heapSort()
	{
		buildHeap();
		
		for(int i=number.length-1; i>0; i--)
		{
			swap(i,0);
			maxHeap(i-1);
		}
	}
	
	public void selectionSort()
	{
		int i,j;
		int min_index;
		
		for(i=0 ; i<number.length; i++)
		{
			min_index = i;
			
			for(j=i+1; j<number.length; j++)
			{
				if(number[min_index] > number[j])
				{
					min_index = j;
					
				}
			}
			
			if(min_index != i)
			{
				swap(min_index, i);
			}
			
		}
	}
	
	public void insertionSort()
	{
		int i,j;
		int tmp;
		
		for(i = 1; i< number.length;i++)
		{
			tmp = number[i];
			for(j=i-1; j>=0 ; j--)
			{
				if(tmp < number[j])
				{
					number[j+1] = number[j];
				}
				else
				{
					break;
				}
			}
			number[j+1] = tmp;
		}
	} 
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < number.length; i++) {
			s.append(number[i] + " ");
		}
		
		return s.toString(); 
	}
	
	public static void main(String[] args) {
		int x[] = {5,2,3,1,4,6,7,8,9};
		MergeSort m = new MergeSort(x);
		//s.insertionSort();
		//s.selectionSort();
		//s.heapSort();
		m.mergeSort(0, m.number.length-1);
		System.out.println(m.toString());
	}
}
