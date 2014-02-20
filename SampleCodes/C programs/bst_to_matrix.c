//Problem Statement
//There is a binary tree of size N. All nodes are numbered between 1-N(inclusive). There is a N*N integer matrix Arr[N][N], all elements are initialized to zero. So for all the nodes A and B, put 
//Arr[A][B] = 1 if A is an ancestor of B (NOT just the immediate ancestor).


#include<stdio.h>
#include<stdlib.h>
#define SIZE 7

struct tree
{
  int data;
  struct tree *left;
  struct tree *right;
};

void update_matrix(int **matrix, int index, int update_data)
{
	int i;

	for(i=0; i< SIZE; i++)
	{
		if(matrix[i][index] == 1)
        {
			matrix[i][update_data] = 1;
        	update_matrix(matrix,i,update_data);
        }
   }

}

void bst_to_matrix(struct tree *root, int **matrix, int size)
{
	int i,j;

	if(root != NULL)
	{
		if(root->data >= 0 && root->data <= size )
		{
			for(i=0; i< SIZE; i++)
			{
				if(matrix[i][root->data] == 1)
				{
					update_matrix(matrix,i,root->data);
				}
			}
		}
	}

	if(root->left != NULL)
	{
		matrix[root->data][root->left->data] = 1;
		bst_to_matrix(root->left, matrix, size);
	}
	
	if(root->right != NULL)
    {
        matrix[root->data][root->right->data] = 1;
		bst_to_matrix(root->right, matrix, size);
    }
	return;
}

struct tree * newNode(int data)
{
  struct tree *node = malloc(sizeof(struct tree));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
  return node;
}

int main()
{
  int **matrix;
  int i, j;

  matrix = malloc(SIZE*sizeof(*matrix));
  for(i=0; i<SIZE; i++)
  {
	matrix[i] = malloc(SIZE*sizeof(*matrix[i]));
	for(j=0; j<SIZE; j++)
	{
		matrix[i][j] = 0;
	}
  }
	
  struct tree *root  = newNode(1);
  root->left         = newNode(2);
  root->right        = newNode(3);
  root->left->left   = newNode(4);
  root->left->right  = newNode(5);
  root->right->right = newNode(6);
  
  bst_to_matrix(root, matrix, SIZE);

  for(i=1; i< SIZE; i++)
  {
	 printf("\n");
     for(j=1; j<SIZE; j++)
	 {
        printf("\t %d",matrix[i][j]);
     }
  } 
  return 0;
}
