#include<stdio.h>
#include<stdlib.h>

struct node 
{
  int data;
  struct node *next;
};

struct node * reverse_list_rec(struct node *root, struct node *prev)
{
  struct node * tmp;
  
  if(root == NULL){
      return NULL;
  }
  
  if(root->next == NULL)
  {
      root->next = prev;
      return root;
  }
  else
  {
      tmp = reverse_list_rec(root->next, root);
      root->next = prev;
      return tmp;
  }
}

struct node * reverse_list_iter(struct node *root)
{
  struct node *prev = NULL;
  struct node *cur = root;
  struct node *tmp;
  
  if(root == NULL){
      return NULL;
  }
  
  while(cur != NULL)
  {
      tmp = cur->next;
      cur->next = prev;
      prev = cur;
      cur = tmp;
  }
  
  return prev;
}

struct node* newNode(int data)
{
  struct node* node = (struct node*) malloc(sizeof(struct node));
  node->data = data;
  node->next = NULL;
  return(node);
}

int main()
{
  struct node *newHead;
  struct node *head      =  newNode(1);
  //head->next             =  newNode(2);
  //head->next->next       =  newNode(3);
  //head->next->next->next =  newNode(4);
  
  newHead = reverse_list_rec(head,NULL);
  head = reverse_list_iter(newHead);
  
  
  while(head != NULL){
    printf("%d  ",head->data);
    head = head->next;
  }
}
