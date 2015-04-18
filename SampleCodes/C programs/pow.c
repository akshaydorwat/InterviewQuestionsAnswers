#include <stdio.h>

int pow(int a, int b)
{
  if (b == 0)
    return 1;
  int answer = a;
  int increment = a;
  int i, j;
  for(i = 1; i < b; i++)
  {
    for(j = 1; j < a; j++)
    {
      answer += increment;
      printf("[%d, %d] Ans : %d increment : %d \n ",i, j, answer, increment);
    }
    increment = answer;
  }
  return answer;
}

/* driver program to test above function */
int main()
{
  printf(" %d \n", pow(5, 3));
  return 0;
}
