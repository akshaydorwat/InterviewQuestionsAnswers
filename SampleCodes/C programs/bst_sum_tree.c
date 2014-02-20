#include<stdio.h>
#include<stdlib.h>

struct tree
{
  int data;
  struct tree *left;
  struct tree *right;
};

int isLeafNode(struct tree *node)
{
    if(node == NULL)
      return 0;
    if(node->left == NULL && node->right == NULL)
     return 1;
     
   return 0; 
}

int isSumTree(struct tree *root)
{
  int ls, rs;
  
  if(root == NULL || isLeafNode(root))
    return 1;
    
  if(isSumTree(root->left) && isSumTree(root->right))
  {
     if(root->left == NULL)
     {
        ls = 0;
     }
     else if(isLeafNode(root->left))
     {
        ls = root->left->data;
     }
     else 
     {
        ls = 2 * root->left->data;
     }

     if(root->right == NULL)
     {
        rs = 0;
     }
     else if(isLeafNode(root->right))
     {
        rs = root->right->data;
     }
     else 
     {
        rs = 2 * root->right->data;
     }
     
      printf("\n ls = %d, rs = %d ls+rs = %d root->data %d ",ls,rs,ls+rs,root->data);
     return (root->data == ls+rs);
  }
  return 0;
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
  struct tree *root  = newNode(26);
  root->left         = newNode(10);
  root->right        = newNode(3);
  root->left->left   = newNode(4);
  root->left->right  = newNode(6);
  root->right->right = newNode(3);
  
  if(isSumTree(root))
    printf("The given tree is a SumTree ");
  else
    printf("The given tree is not a SumTree ");
 
  return 0;
}
