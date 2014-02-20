#include<stdio.h>
#include<stdlib.h>

struct tree
{
  int data;
  struct tree *left;
  struct tree *right;
};

int hashset[10] = {0};

void freq_counter(struct tree *root)
{
  int number;
  
  if(root == NULL)
    return;
  
  number = root->data;
  
  while(number > 1)
  {
    hashset[number%10] ++;
    number /= 10;
  }
  
  freq_counter(root->left);
  freq_counter(root->right);
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
  int i;
  struct tree *root = newNode(190);
  root->left        = newNode(150);
  root->right       = newNode(1120);
  root->left->left  = newNode(130);
  root->left->right = newNode(180); 
  root->left->left->left  = newNode(110);
  root->left->left->right  = newNode(140);
 
  freq_counter(root);
  for(i=0 ; i<10; i++)
  {
      printf("\n hashset[%d] : %d",i,hashset[i]);
  }
  
  return 0;
}
