#include <stdio.h>

void sort_zero_one(int size, int a[size]){
  int i,j;
  i = 0;
  j = size-1;

  
  while(i<j){
    while(a[i] == 0 && i<j){
      i++;
    }

    while(a[j] == 1 && j>i){
      j--;
    }

    if(a[i] == 1 && a[j] == 0){
      a[i] = 0;
      a[j] = 1;
    }
  }
  
}
