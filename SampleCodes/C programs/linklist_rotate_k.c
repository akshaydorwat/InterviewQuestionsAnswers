
struct ndoe *rotate_list_k(struct node *head, int k){

  int i = 0;
  struct node *temp = head, *prev;;
  
  for( i=0; i<k && temp != NULL; i++){
    temp = temp->next;
  }

  if(temp == NULL || temp->next == NULL ){
    return head;
  }
  
  rotate_point = temp->next;
  temp->next = NULL;
  new_head = rotate_point;

  while(rotate_point->next != NULL){
    rotate_point = rotate_point->next;
  }

  rotate_point->next = head;
  return new_head;
  
}
