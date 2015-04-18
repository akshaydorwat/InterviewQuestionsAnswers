#include <stdio.h>

struct node 
{
  int data;
  struct node *left;
  struct node *right;
};

stack<struct node *> s;

struct node* newNode(int data)
{
  struct node* new_node = (struct node *)malloc(sizeof(struct node));
    new_node->data = data;
    new_node->left = new_node->right = NULL;
    return (new_node);
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
   inorder(root);
  
  return 0;
}
