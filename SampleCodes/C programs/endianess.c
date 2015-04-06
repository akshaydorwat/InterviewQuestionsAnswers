#include <stdio.h>

int main(int argc, char **argv){
  int i = 1;
  char *a = (char*) &i;

  if(*a == 1){
    printf("system is Little Endian\n");
  }else{
    printf("system is Big Endian\n");
  }
  
}
