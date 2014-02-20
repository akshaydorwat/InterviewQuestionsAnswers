//problem statement
//Clone a singly link list whose nodes contain, apart from next pointers, an extra pointer to any random node. 
//The random pointer of a node N could be after N, before N or the node N itself.

#include <stdio.h>
#include <stdlib.h>

struct node
{
  int data;
  struct node *next;
  struct node *random;
};

struct node * clone_list(struct node *root)
{
  struct node *head = NULL;
  struct node *copy;
  struct node *first;
  struct node *second, *temp;
  
  first = root;
  second = root->next;
  
  while(1)
  {
    copy  = malloc(sizeof(struct node));
    copy->data = first->data;
    first->next = copy;
    copy->next = second;
    
    if(head == NULL)
    {
       head = copy;
    }
    
    first = second;
    if(first == NULL)
      break;
    second = second->next;
  }
  
  first = root;
  while(first != NULL)
  {
    first->next->random = first->random->next;
    first = first->next->next;
  }
  
  first = root;
  second = root->next;
  while(1)
  {
    first->next = first->next->next;
    if(first->next == NULL)
      break;
    second->next = second->next->next;
    first = first->next;
    second = second->next;
  }
  
  return head;
} 

int main()
{
  struct node a1,a2,a3,a4,a5;
  struct node *temp;
  
  a1.data = 1;
  a1.next = &a2;  
  a1.random = &a3;
  
  a2.data = 2; 
  a2.next = &a3;
  a2.random = &a1;
  
  a3.data = 3; 
  a3.next = &a4;
  a3.random = &a5;
  
  a4.data = 4;
  a4.next = &a5; 
  a4.random = &a3;
  
  a5.data = 5; 
  a5.next = NULL;
  a5.random = &a2;
 
  temp = clone_list(&a1) ; 
  
  while(temp != NULL)
  {
     printf("%d -> %d \t",temp->data,temp->random->data);
     temp = temp->next;
  }
 
}
