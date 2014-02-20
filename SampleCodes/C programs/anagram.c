#include<stdio.h>
#include<string.h>
#define SIZE 2


int anagram(char str[], char inp[])
{
    int hashlist[256] = {0};
   
    strlen(inp);
    int num_uniq_char = 0;
    int num_comp_char = 0;
    int i;
    
    for(i=0; i<strlen(str); i++)
    {
        if(hashlist[str[i]] == 0)
        {
            num_uniq_char ++;
        }
        hashlist[str[i]] ++;
    }
    
    for(i=0; i<strlen(inp); i++)
    { 
        if(hashlist[inp[i]] > 0){
            hashlist[inp[i]]--;
            
            if(hashlist[inp[i]] == 0){
                num_comp_char ++;
                if( num_comp_char ==  num_uniq_char){
                    return (i == strlen(inp)-1 );
                }
            }
        }
        else
        {
            return 0;
        }
    }
}

int main()
{
  char str[SIZE][10];
  char inp[10];
  int i;
  
  for(i=0; i<SIZE; i++)
  {
      printf("\nEnter string %d",i);
      scanf("%s",str[i]);
  }
  
  printf("\nEnter inp string :");
  scanf("%s",inp);
  
  for(i=0; i<SIZE; i++)
  {
      if(anagram(str[i],inp))
      {
          printf("\n %s is anagram of %s",str[i],inp);
      }
      else
      {
          printf("\n %s is not anagram of %s",str[i],inp);      
      }
  }
  
}
