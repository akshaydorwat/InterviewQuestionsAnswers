#include <stdio.h>

unsigned int reverse_bit(unsigned int x){

  int size = sizeof(x);
  unsigned int temp = 0;
  
  for(i=0; i<size; i++){
    if(x & (1 << i)){
      temp |= (1 << (size - i -1));
    }
  }
  
  return temp;
}

int main(int argc, char *argv[])
{
  reverse_bit(2);
  return 0;
}
