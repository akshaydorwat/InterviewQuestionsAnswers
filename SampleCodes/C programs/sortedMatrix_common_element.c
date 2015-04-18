/*
  Given a matrix where every row is sorted in increasing order. Write a function that finds and returns a common element in all rows. If there is no common element, then returns -1.
 */
#include <stdio.h>

int common_element( int row, int col, int arr[row][col]){

  int i;
  int min_row, min_col;
  int equal_count;
  int column[row];
  min_col = col-1;
  min_row = 0;
  
  for(i=0; i<row; i++){
    column[i] = col - 1;
  }

  while(min_col >= 0){
    
    for(i=0; i< row; i++){
      if(arr[min_row][column[min_row]] > arr[i][column[i]]){
        min_row = i;
      }
    }

    
    equal_count = 0;

    for(i=0; i< row; i++){
      if(arr[min_row][column[min_row]] == arr[i][column[i]]){
        equal_count++;
      }else{
        column[i] = column[i] - 1;
        if(min_col > column[i]){
          min_col = column[i];
        }
      }
      printf("column index [%d] : %d \n", i, column[i]);
    }

    printf("min element : %d || min column index : %d\n", arr[min_row][column[min_row]], min_col);
    
    if(equal_count == row){
      return arr[min_row][column[min_row]];
    }
  }

  return -1;
}


int main(int argc, char *argv[])
{
  int ret;
  
  int mat[4][5] = { {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9}
  };

  ret = common_element( 4, 5, mat);

  printf("common element : %d \n", ret );
  return 0;
}
