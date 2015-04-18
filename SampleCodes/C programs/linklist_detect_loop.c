#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;
  struct node *next;
};

int detect_loop(struct node *head){

  if(head == NULL || head->next == NULL){
    return 0;
  }

  struct node *slow = head;
  struct node *fast = head->next->next;
  int k = 1;
  int i;
  
  while(slow != NULL && fast->next != NULL){
    if(slow == fast){
      break;
    }
    slow = slow->next;
    fast = fast->next->next;
  }

  printf(" data : %d \n", slow->data);
  printf("Pointer matched ! \n");
  
  if(fast->next == NULL){
    return 0;
  }

  while(fast->next != slow){
    k++;
    fast = fast->next;
  }

  printf("k = %d \n", k);
  
  slow = head;
  fast = head;

  for(i=0; i<k; i++){
    fast = fast->next;
  }

  while(slow != fast){
    slow = slow->next;
    fast = fast->next;
  }
  fast = fast->next;

  while(fast->next != slow){
    fast = fast->next;
  }
  
  fast->next = NULL;

  return 1;
}

struct node *new_node(int data){
  struct node *temp = malloc(sizeof(struct node));
  temp->data = data;
  temp->next = NULL;
}


int main(int argc, char *argv[])
{
  struct node *head = new_node(0);
  struct node *dup;
  
  head->next = new_node(1);
  head->next->next = new_node(5);
  dup = new_node(7);
  head->next->next->next  = dup;
  head->next->next->next->next  = new_node(17);
  head->next->next->next->next->next  = new_node(20);
  head->next->next->next->next->next->next  = new_node(40);
  head->next->next->next->next->next->next->next = dup;
  
  //function calll here
  detect_loop(head);
  
  while(head != NULL){
    printf("%d-> ", head->data);
    head = head->next;
  }
  printf("\n");
  return 0;
}
