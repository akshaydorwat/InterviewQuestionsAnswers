#include <stdio.h>
#include <stdlib.h>

struct node 
{
  int data;
  struct node *left;
  struct node *right;
};


struct node* newNode(int data)
{
  struct node* new_node = (struct node *)malloc(sizeof(struct node));
  new_node->data = data;
  new_node->left = new_node->right = NULL;
  return (new_node);
}


int _sum_in_binary_tree(struct node *root, int sum, int sub_sum){

  int curr_sum;
  int result = 0;
    
  curr_sum = sub_sum + root->data;

  if(sum == curr_sum){
    return 1;
  }
    
  if(root->left != NULL){
    result = result | _sum_in_binary_tree(root->left, sum, curr_sum);
  }

  if(root->right != NULL){
    result = result | _sum_in_binary_tree(root->right, sum, curr_sum);
  }

  return result;
}

int sum_in_binary_tree(struct node *root, int sum){

  int sub_sum = 0;
  
  if(root == NULL){
    return 0;
  }else{
    return _sum_in_binary_tree(root, sum, sub_sum);
  }

}

int main(int argc, char *argv[])
{

  // Let us create the tree shown in above diagram
  struct node *root        = newNode(10);
  root->left        = newNode(12);
  root->right       = newNode(15);
  root->left->left  = newNode(25);
  root->left->right = newNode(30);
  root->right->left = newNode(36);
 
  // Convert to DLL
  int ret = sum_in_binary_tree(root, 22);
  printf("Ans : %d\n ", ret);
  
  return 0;
}
