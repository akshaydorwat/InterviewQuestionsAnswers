#include<stdio.h>
#define SIZE 3
#define MAX 5

int val[SIZE+1];
int weight[SIZE+1];
int knap[SIZE+1][MAX+1];

void knapsack()
{
    int val2, val1, i, j;
    
    for(i=1; i<= SIZE; i++){
        
        for(j=1; j<=MAX; j++){
            val1 = 0;
            val2 = 0;
            
            val1 =  knap[i-1][j];  
            
            if(weight[i] <= j)
            {
                val2 = val2 + val[i];
                
                if((j-weight[i]) > 0)  
                {
                    val2 = val2 + knap[i-1][j-weight[i]];
                }
            }
            
          knap[i][j] = (val1 > val2) ? val1 : val2;
          
        }
    }
    
     for(i=0; i<= SIZE; i++){
        printf("\n");
        for(j=1; j<=MAX; j++){
        
             printf("\t %d",knap[i][j]);  
        }
     }
     printf("\n");
} 

int main()
{
  int i;
  
    for(i=0; i<=MAX; i++)
    {
        knap[0][i] = 0;
    }

    val[0] = 0;
    val[1] = 5;
    val[2] = 3;
    val[3] = 4;
    
    weight[0] = 0;
    weight[1] = 3;
    weight[2] = 2;
    weight[3] = 1;
    
    knapsack();
    
}
