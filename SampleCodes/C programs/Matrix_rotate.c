#include<stdio.h>

int rotate_matrix(int matrix[4][4], int n){

  int layer;
  int first;
  int last;
  int offset;
  int top;
  int i;
    
  for(layer= 0; layer < n/2; layer ++)
  {
      first = layer;
      last  = n-1-layer;
      
      for(i = first; i<last; i++)
      {
          offset = i-first;
          top = matrix[first][i];
                  
          matrix[first][i]           = matrix[i][last];
          matrix[i][last]            = matrix[last][last-offset];
          matrix[last][last-offset]  = matrix[last-offset][first];
          matrix[last-offset][first] = top;
      }  
  }
  
  display_matrix(matrix, 4);
}

int display_matrix(int matrix[4][4], int n){
  
  int i,j;
  
  for(i=0; i<n; i++){
    
      printf("\n");
      for(j=0; j<n; j++){
      
          printf("\t %d",matrix[i][j]);
      }
  }
}


int main(){
   
   int mat[4][4] ={{1, 2, 3, 4},{5,6,7,8},{9, 10, 11, 12},{12, 14, 15, 16}}; 
   
   display_matrix(mat, 4);
   rotate_matrix(mat, 4);
   
}
