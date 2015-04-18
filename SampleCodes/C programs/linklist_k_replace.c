/*
 * Given a singly linked list, swap kth node from beginning with kth node from end. Swapping of data is not allowed, only pointers should be changed
 */

#include <stdio.h>
#include <stdlib.h>

struct node 
{
  int data;
  struct node *next;
};


struct node* newNode(int data)
{
  struct node* node = (struct node*) malloc(sizeof(struct node));
  node->data = data;
  node->next = NULL;
  return(node);
}


void replace_kth_node(struct node **head, int n){

  if(n < 0){
    return;
  }

  if(*head == NULL){
    return;
  }

  int kth_start;
  int kth_end;
  int count;
  int flag1 = 1, flag2 = 1;
  int i;
  
  struct node *temp = *head;
  struct node *prev_start = NULL, *start;
  struct node *prev_end = NULL, *end;
  
  for(count = 0; temp != NULL; count++){
    temp = temp->next;
  }

  kth_start = n-1;
  kth_end = count-n;
  temp = *head;

  i = 0;
  while(temp != NULL){

    if(flag1){
      if(i == (kth_start) ){
        start = temp;
        flag1 = 0;
      }else{
        prev_start = temp;
      }
    }

    if(flag2){
      if(i == (kth_end) ){
        end = temp;
        flag2 = 0;
      }else{
        prev_end = temp;
      }
    }

    i++;
    temp = temp->next;
  }
 
  if(prev_start != NULL){
    prev_start->next = end;
  }

  if(prev_end != NULL){
    prev_end->next = start;
  }

  temp = start->next;
  start->next = end->next;
  end->next = temp; 

  if(n == 1){
    *head = end;
  }

  if(n == count){
    *head = start;
  }
  
}

int main()
{
  
  struct node *head      =  newNode(1);
  head->next             =  newNode(2);
  head->next->next       =  newNode(3);
  head->next->next->next =  newNode(4);

  replace_kth_node(&head, 2);
  
  while(head != NULL){
    printf("%d  ",head->data);
    head = head->next;
  }
  
}
