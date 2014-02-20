#include<stdio.h>
#include<stdlib.h>

FindWordCount(char *word, char **matrix, int curRow, int curCol, int rows, int cols)
{
       
    if (curRow >= rows) return 0;
    if (curCol >= cols) return 0;
        
    if (*word != matrix[curRow][curCol]) return 0;

    // goto next letter in the word.
    word++;

    // no more letters left. we got a match.
    if (*word == '\0') 
	return 1;	

    int WordCount = 0;

    // go right
    WordCount += FindWordCount(word, matrix, curRow+1, curCol, rows, cols);    
    // go down
    WordCount += FindWordCount(word, matrix, curRow, curCol+1, rows, cols);    
    // go diag
    WordCount += FindWordCount(word, matrix, curRow+1, curCol+1, rows, cols);    

    return WordCount;
}

int main()
{
    char matrix[4][6] = {{'w' , 's' , 'r' , 't' , 'g' , 'g' }, 
                         {'a' , 'a' , 'c' , 'h' , 'i' , 'n' }, 
                         {'k' , 'c' , 'h' , 'u' , 'j' , 'j' }, 
                         {'o' , 'h' , 'i' , 'n' , 'y' , 'q' }};

    char word[] = "sachin";
    
    printf("%d",FindWordCount(word, **matrix, 0, 0, 4, 6));    
}
