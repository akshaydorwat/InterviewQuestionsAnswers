/*
  Unsorted array and a position ‘P’. Return the element that is likely to come to the given location upon sorting the array. Do it 0(n).
 */

#include <stdio.h>
#include <stdlib.h>


int limit = 0;
int *array;
int index = 0;

void min_heapify(int n){
  int temp;
  int parent;
  
  if(n > 0){
    parent = (n-1)/2;
    if(array[parent] >  array[n]){
      temp = array[parent];
      array[parent] = array[n];
      array[n] = temp;
    }
    min_heapify(parent);
  }
  
}

void add(int num){
  int i;
  
  if(index < limit){
    index++;
    array[index] = num;
    min_heapify(index);
  }else{
    index++;
    array[index] = num;
    min_heapify(index);
    for(i = 0; i<= index; i++){
    printf("%d -> ", array[i]);
  }
  printf("\n");
    index--;
  }

  
}


int find_n_position(int num[], int n){

  int i;

  for(i = 0 ; i< n; i++){
    add(num[i]);
  }
}

int main(int argc, char *argv[])
{
  int arr[] = {10, 15, 55, 89, 12, 100, 105, 1, 5, 17, 27, 37};
  int i= 0;
  limit = 5;
  array = malloc(sizeof(int) * 6);
  find_n_position(arr, 12);

  
  
  return 0;
}
