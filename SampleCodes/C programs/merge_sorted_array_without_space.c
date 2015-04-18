#include <stdio.h>

void merge_sorted_array(int *arr1, int *arr2, int m, int n){

  int new_count = m+n;

  //move element
  for(i=m-1; i>=0; i--){
    count--;
    arr1[new_count] = arr1[i];
  }

  i = new_count;
  j = 0;
  runner = 0;
  while(i < m+n && j < n){

    if(arr1[i] > arr2[j]){
      arr1[runner] = arr2[j];
      j++;
      runner++;
    } else if(arr1[i] < arr2[j]){
      arr1[runner] = arr1[i];
      i++;
      runner++;
    }
  }
  
}

int main(int argc, char *argv[])
{
  
  return 0;
}
