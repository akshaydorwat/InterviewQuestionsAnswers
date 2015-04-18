#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;
  struct node *next;
};


struct node *new_node(int data){
  struct node *temp = malloc(sizeof(struct node));
  temp->data = data;
  temp->next = NULL;
}

void print_reverse(struct node *head){

  if(head == NULL){
    return;
  }
  print_reverse(head->next);
  printf("%d \t", head->data);
}

struct node * reverse(struct node *head, struct node *prev){

  struct node *temp;
  
  if(head == NULL){
    return prev;
  }

  temp = reverse(head->next, head);
  head->next = prev;
  return temp;
}

struct node *reverse_iter(struct node *head){

  struct node *prev = NULL;
  struct node *curr = head;

  while(curr != NULL){
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr = next;
  }

  return prev;
}
int main(int argc, char *argv[])
{
  struct node *head = new_node(0);
  head->next = new_node(1);
  head->next->next = new_node(5);
  head->next->next->next  = new_node(7);
  head->next->next->next->next  = new_node(17);
  head->next->next->next->next->next  = new_node(20);
  head->next->next->next->next->next->next  = new_node(40);

  //function calll here
  print_reverse(head);

  head = reverse(head, NULL);

  while(head != NULL){
      printf("%d \t", head->data);
      head = head->next;
  }
  
  printf("\n");
  return 0;
}
