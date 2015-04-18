#include <stdio.h>
#include <stdlib.h>

struct node 
{
  int data;
  struct node *next;
};

void new_node(struct node **head_ref, int data){
  
  struct node *temp = malloc(sizeof(struct node));
  temp->data = data;
  temp->next = NULL;
  
  if(*head_ref != NULL){
    temp->next = *head_ref;
  }
  *head_ref = temp;
}

void print(struct node *head){
  while(head != NULL){
    printf(" %d -> ", head->data);
    head = head->next;
  }
  printf("\n");
}

struct node * insert_sort(struct node *head_ref){
  struct node *head = head_ref;
  struct node *curr = head->next;
  struct node *prev_curr = head;

  struct node *temp;
  struct node *runner;
  struct node *prev_runner;
  struct node *next;
  
  while(curr != NULL){
    
    next = curr->next;
    runner = head;
    prev_runner = NULL;
    
    while(runner != curr){
      
      if(runner->data > curr->data){
        if(runner == head){
          temp = head;
          head = curr;
          curr->next = temp;
        }else{
          prev_runner->next = curr;
          curr->next = runner;
        }
        break;
      }
      
      prev_runner = runner;
      runner = runner->next;
    }

    if(runner != curr){
      prev_curr->next = next;
      curr = prev_curr;
      if(next == NULL){
        break;
      }
    }else{
      prev_curr = curr;
      curr = next;
    }
    
  }
  
  return head;
  
}


int main(int argc, char *argv[])
{
  struct node *head = NULL;
  int i;
  
  //for(i=0; i < 5; i++)
  new_node(&head, 1);
  new_node(&head, 2);
  new_node(&head, 3);
  new_node(&head, 4);
  new_node(&head, 5);
  new_node(&head, 0);
  
  
  head = insert_sort(head);
  
  print(head);
  return 0;
}
