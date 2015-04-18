/*Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line. Delete points from the linked list which are in the middle of a horizontal or vertical line.

Examples:

Input:  (0,10)->(1,10)->(5,10)->(7,10)
                                  |
                                  (7,5)->(20,5)->(40,5)
Output: Linked List should be changed to following
(0,10)->(7,10)
          |
        (7,5)->(40,5) */



#include <stdio.h>
#include <stdlib.h>

struct node {
  int x;
  int y;
  struct node *next;
};


struct node *new_node(int x , int y){
  struct node *temp = malloc(sizeof(struct node));
  temp->x = x;
  temp->y = y;
  temp->next = NULL;
}

void rm_middle(struct node *head)
{
  struct node *curr, *prev, *temp;

  if(head == NULL){
    return;
  }
  
  prev = head;
  curr = head->next;

  while(curr != NULL && curr->next != NULL){
    
    if( prev->x == curr->x || prev->y == curr->y ){
      if(prev->x == curr->next->x || prev->y == curr->next->y){
        temp = curr->next;
        prev->next = curr->next;
        free(curr);
        curr = temp;
      }else{
        curr = curr->next;
      }
    }else{
      prev = curr;
      curr = curr->next;
    }
  }
}

int main(int argc, char *argv[])
{
  struct node *head = new_node(0, 10);
  head->next = new_node(1, 10);
  head->next->next = new_node(5, 10);
  head->next->next->next  = new_node(7, 10);
  head->next->next->next->next  = new_node(7, 5);
  head->next->next->next->next->next  = new_node(20, 5);
  head->next->next->next->next->next->next  = new_node(40, 5);

  
  rm_middle(head);
  
  while(head != NULL){
    printf(" ( %d, %d)-> ", head->x, head->y);
    head =head->next;
  }
  printf("\n");
  return 0;
}
