/*
 * Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
 * For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should become 5->12->7->10->17->2->13->4->11->6 and second list should become empty.
 */

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

void merge_list(struct node *h1, struct node **h2){
  
  if(head1 == NULL || head2 == NULL){
    return;
  }

  struct node *head1 = h1, *head1_next;
  struct node *head2 = *h2, *head2_next;
  
  while(head1 != NULL && head2 != NULL ){
    
    head1_next = head1->next;
    head2_next = head2->next;

    head1->next = head2;
    head2->next = head1_next;

    head1 = head1_next;
    head2 = head2_next;
  }
  
}


struct node * merge_sorted_list(struct node *h1, struct node *h2){

  struct node *result;

  if(h1 == NULL){
    return h2;
  }else if(h2 == NULL){
    return h1;
  }
  
  if(h1->data < h2->data){
    result = h1;
    result->next = merge_sorted_list(h1->next, h2);
  }else{
    result = h2;
    result->next = merge_sorted_list(h1, h2->next);
  }

  return result;
  
  
}

int main(int argc , char **argv){

  struct node *head1 = new_node(5);
  head->next = new_node(7);
  head->next->next = new_node(17);
  head->next->next->next = new_node(13);
  head->next->next->next->next = new_node(11);

  struct node *head22 = new_node(12);
  head2->next = new_node(10
  head2->next->next = new_node(2);
  head2->next->next->next = new_node(4);
  head2->next->next->next->next = new_node(6);
  
  while(head1 != NULL){
    printf("%d -> ", head1->data);
    head1 = head1->next;
  }
                         
}
      
