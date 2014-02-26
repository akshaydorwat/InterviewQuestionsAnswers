package array;

/*There is a N*N integer matrix Arr[N][N]. From the row r and column c, we can go to any of the following three indices:

 I.                Arr[ r+1 ][ c-1 ] (valid only if c-1>=0)

 II.               Arr[ r+1 ][ c ]

 III.              Arr[ r+1 ][ c+1 ] (valid only if c+1<=N-1)

 So if we start at any column index on row 0, what is the largest sum of any of the paths till row N-1.
 
 1  2  3 
 4  5  6  
 7  8  9
 
 * */

public class MatrixMaxinumValue {
	
	int matrix[][];
	
	public MatrixMaxinumValue(int matrix[][]){
		this.matrix = matrix;
	}
	
	public int maxOfMatrix(int row, int col, int N)
	{
		int case1=0, case2=0, case3=0, max;
		
			if(((col-1) >= 0)&&((row+1)<=N-1))
				case1 = maxOfMatrix(row+1, col-1, N);
			
			if((row+1)<=N-1)
				case2 = maxOfMatrix(row+1, col, N);
			
			if(((col+1) <= N-1)&&((row+1)<=N-1))
				case3 = maxOfMatrix(row+1, col+1, N);
			
			if((case1 >= case2)&&(case1 >= case3))
				max = case1;
			else if((case2 >= case1)&&(case2>=case3))
				max = case2;
			else
				max = case3;
			
			return max + matrix[row][col];
	}
		
	public static void main(String[] args) {
		
		int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		MatrixMaxinumValue m = new MatrixMaxinumValue(mat);
		System.out.println(m.maxOfMatrix(0, 0, 3));
	}

}
