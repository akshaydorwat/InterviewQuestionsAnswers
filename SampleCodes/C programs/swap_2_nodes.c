
struct node * alternate_nodes(struct node *root){

  if(root == NULL){
    return NULL;
  }
  
  prev  = root;
  curr = root->next;
  new_head = NULL;

  while(curr->next != NULL){
    next = curr->next;
    curr->next = prev;
    prev->next = next;
    prev = next;
    curr = next->next;
  }
}
