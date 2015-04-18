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
  
  while(head != NULL){
    printf("%d-> ", head->data);
    head = head->next;
  }
  printf("\n");
  return 0;
}
