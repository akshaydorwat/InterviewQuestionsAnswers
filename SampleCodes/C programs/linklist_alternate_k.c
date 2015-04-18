

void alternate(struct node *head, int k){
  int count = 0;
  struct node *prev = NULL;
  struct node *temp = head;
  
  while(temp != NULL && count < k){
    next = temp->next;
    temp->next = prev;
    prev = temp;
    temp = next;
    count ++
  }

  if(temp != NULL){
    head->next = alternate(temp, k);
  }

  return temp;
}
