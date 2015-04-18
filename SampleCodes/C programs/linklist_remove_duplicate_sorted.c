#include <stdio.h>
#include <stdlib.h>

struct node
{
  int data;
  struct node *next;
};


struct node * new_node(int data){
  struct node *temp = malloc(sizeof(struct node));
  temp->next = NULL;
  temp->data = data;
}

void remove_duplicate(struct node *head)
{
  if(head == NULL)
  {
    return;
  }

  struct node *curr, *temp;

  curr = head;

  while(curr != NULL && curr->next != NULL)
  {
    if(curr->data == curr->next->data)
    {
      temp = curr->next;
      curr->next = curr->next->next;
      curr = curr->next;
      free(temp);
    }else{
      curr = curr->next;
    }
  }
}

int main(int argc , char **argv){

  struct node *head = new_node(1);
  head->next = new_node(1);
  head->next->next = new_node(2);

  remove_duplicate(head);

  while(head != NULL){
    printf("%d -> ", head->data);
    head = head->next;
  }
}
