#include <stdio.h>
#define MAX 14

void min_heapify(int a[MAX], int n, int size){

  int left = 2*n + 1;
  int right = 2*n + 2;
  int smallest = n;
  int temp;
  int i;
  
  if(left < size && a[n] > a[left]){
    smallest = left;
  }

  if(right < size && a[smallest] > a[right]){
    smallest = right;
  }

  if(smallest != n){
    temp = a[smallest];
    a[smallest] = a[n];
    a[n] = temp;
    min_heapify(a, smallest, size);
  }
}


void build_heap(int a[MAX]){

  int size = MAX;
  int i, j;

  for(i=size/2; i>=0; --i){
    min_heapify(a, i, MAX);
  }
}

void heap_sort(int a[MAX]){
  int i;
  int temp;
  
  for(i=MAX-1; i>=0; i--){
    temp = a[0];
    a[0] = a[i];
    a[i] = temp;
    min_heapify(a,0,i);
  }
}

int main(){
  
  int i;
  int a[MAX] = {1, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
  build_heap(a);
  heap_sort(a);
  while(i < MAX){
    printf(" %d ", a[i]);
    i++;
  }
  printf("\n");
}
