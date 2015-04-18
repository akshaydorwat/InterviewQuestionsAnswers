#include <stdio.h>

int main(int argc, char **argv){
  int num = 35;
  int i = 1;
  int square;

  if(num <  0){
    num = -num;
  }

  square = num;
  printf("Number is %d \n", num);
  
  while(i < num){
    square <<= 1;
    i <<= 1;
    printf(" i = %d , square = %d , num = %d\n", i, square, num);
  }

  if(i != num){
    square >>= 1;
    i >>= 1;
        
    while(i < num){
      square += num;
      i++;
    }
  }

  printf("Square of number is %d ", square);
}
