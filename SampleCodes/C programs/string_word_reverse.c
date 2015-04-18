#include <stdio.h>

void reverse(char *str, int start, int end){

  char temp;

  while(start < end){
    temp = str[start];
    str[start] = str[end];
    str[end] = temp;
    start++;
    end--;
  }
}

int main(int argc, char *argv[])
{

  char str[] = "akshay sunil dorwat";
  int i=0;
  int start;
  
  while(1){

    while(str[i] == ' ')
      i++;
    
    start = i;

    while(str[i] != ' ' && str[i] != '\0'){
      i++;
    }

    reverse(str, start, i-1);
    
    if(str[i] == '\0')
      break;
        
  }

  printf("str : %s ", str);
  printf("\n");
  return 0;
}

