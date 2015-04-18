#include<stdio.h>

void print_matrix_spiral( int row, int col, int a[row][col]){
  int i;

  int start_row;
  int start_col;
  
  start_row = 0;
  start_col = 0;


  while(start_col < col && start_row < row){

    for(i=start_col; i<col; ++i)
      printf("%d ", a[start_row][i]);
    start_row++;

    for(i=start_row; i<row; ++i)
      printf("%d ", a[i][col-1]);
    col--;

    if(start_row < row){
      for(i=col-1; i>=start_col; --i)
        printf(" %d ",a[row-1][i]);
      row--;
    }

    if(start_col < col){
      for(i=row-1; i>= start_row; --i)
        printf("%d ",a[i][start_col]);
      start_col++;
    }
          
  }

  
}
int main()
{
  
  int a[3][6] = { {1,  2,  3,  4,  5,  6},
                  {7,  8,  9,  10, 11, 12},
                  {13, 14, 15, 16, 17, 18}
  };

  print_matrix_spiral(3, 6, a);
   
  return 0;
}



