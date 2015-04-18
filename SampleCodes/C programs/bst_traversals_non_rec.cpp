#include <iostream>
#include <stack>
#include <stdlib.h>

using namespace std;

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

void preorder(struct node *root){

  struct node *temp;
  
  if(root == NULL){
    return;
  }

  s.push(root);

  while(!s.empty()){

    temp = s.top();
    s.pop();
    cout << temp->data << " \t";
    if(temp->right != NULL){
      s.push(temp->right);
    }
    if(temp->left != NULL){
      s.push(temp->left);
    }
  }
}

void inorder(struct node *root){

  if(root == NULL){
    return;
  }

  struct node *curr = root;

  while(1){

    if(curr != NULL){
      s.push(curr);
      curr = curr->left;
    }else if(curr == NULL && !s.empty()){
      curr = s.top();
      s.pop();
      cout << curr->data << "\t";
      curr = curr->right;
    }else{
      break;
    }
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
   inorder(root);
  
  return 0;
}
