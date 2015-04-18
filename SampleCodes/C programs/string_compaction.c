#include <stdio.h>

int main(int argc, char *argv[])
{
  char *str = "Akshay Dorwat sunil sahil";
  int runner_index = 0;
  int index = 0;
  int count = strlen(str);
  int start;
  
  while(1){

    while(str[index] == ' ' && index < count){
      index ++;
    }
    
    start  = index;
    
    while(str[index] != ' ' && index < count){
      index ++;
    }
    
    strcpy( str[runner_index], str[start], index-start-1);
    runner_index = runner_index + index-space_start-1;

    if(index == count){
      if(runner_index > 0){
        str[runner_index] = '\0';
      }
      break;
    }
    
    index++;   
    
  }
  
  return 0;
}
