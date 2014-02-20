//problem statement
// Write a program to find roatation index
 
#include <stdio.h>
#include <stdlib.h>
#define SIZE 20

int rotation_index(int *array, int size)
{
	int mid, high, low;
	low = 0;
	high = size-1;
	mid = (low+high) / 2;

	while(low != mid && mid != high)
	{
		if(array[mid-1] > array[mid])
		{
			return mid;
		}
		else if(array[low] < array[mid] && array[mid] > array[high])
		{
			low = mid;
		}
		else
		{
			high = mid;
		}
		mid = (low + high)/2;
	}
	return high;
}

void init_array( int *array, int size){
  int i;
    
  for(i=0; i<size; i++)
  {
    array[i] = i;
  }
}

void rotate_array(int *array, int size, int rotate_count){
  int i;
  int k,j;
  int temp;
  
  for(i=0; i<gcd(size,rotate_count); i++){
    j=i;
    temp = array[i];
    while(1)
    {
      k = j+rotate_count;
      if(k>=size){
        k=k-size;
      }
      if(k==i)
      {
        printf("\n k = %d , i = %d , j = %d ",k,i,j);         
        break;
      }
      else
	  {
        array[j] = array[k];
        j=k;
      }
    }
    array[j] = temp;
  }

}

int gcd(int size, int rotate_count){
  if(rotate_count == 0)
  { 
    return size;
  }
  
  return(gcd(rotate_count, size%rotate_count));
}

int main(){
  int i;
  int array[SIZE];
  
  init_array(array,SIZE);
  rotate_array(array,SIZE,7);

  printf("\n");  
  for(i=0; i<SIZE; i++)
  {
    printf("\t %d ",array[i]);
  }

  printf("\n rotated times  : %d value is %d",SIZE - rotation_index(array,SIZE),array[rotation_index(array,SIZE)]);
}
