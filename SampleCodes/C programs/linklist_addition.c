
#include<stdio.h>
#include<stdlib.h>

struct list{
  int data;
  struct list *next;
};

struct list * newNode(int data) {
  struct list *node = malloc(sizeof(struct list));
  node->data = data;
  node->next = NULL;
  return node;
}


struct list *addition_iter(struct list *l1, struct list *l2) {
  struct list *head = NULL;
  struct list *result;
  struct list *prev = NULL;
    
  int carry = 0;
  int value = 0;
  if ( l1 == NULL && l2 == NULL ) {
    return NULL;
  }
      
  while ( l1 != NULL && l2 != NULL ) {
    
    result = newNode(0);
    value = carry;
        
    if ( l1 != NULL && l2 != NULL ) {
      value += (l1->data + l2->data);
      l1 = l1->next;
      l2 = l2->next;
    } else if (l1 != NULL) {
      value += (l1->data);
      l1 = l1->next;
    } else if (l2 != NULL) {
      value += (l2->data);
      l2 = l2->next;
    }
        
    result->data = value % 10;
    carry = (value > 10) ? 1 : 0;
         
    if (head == NULL)
      head = result;
    else
      prev->next = result;
        
    prev = result;
  }
      
  if (carry > 0) {
    result->next = newNode(carry);
  }
    
  return head;
}

struct list *addition_rec(struct list *l1, struct list *l2, int carry) {
  int value;
  struct list *result;
  struct list *more;

  result =  malloc(sizeof(struct list));
  result->data = carry;
  value = carry;
    
  if ((l1 == NULL) && (l2 == NULL)) {
    return NULL;
  }
    
  if (l1 != NULL) {
    value = value + l1->data;
  }
    
  if (l2 != NULL) {
    value = value + l2->data;
  }
    
  printf("\n%d", value);
  result->data = value % 10;
  more = addition_rec(l1 == NULL ? NULL : l1->next,
                      l2 == NULL ? NULL : l2->next,
                      value > 10 ? 1 : 0);
    
  result->next = more;
  return result;
}

int main() {
  struct list a1, a2, a3;
  struct list b1, b2, b3;
  struct list *result;
    
  a1.data = 1;
  a1.next = &a2;
  a2.data = 2;
  a2.next = &a3;
  a3.data = 9;
  a3.next = NULL;
    
  b1.data = 1;
  b1.next = &b2;
  b2.data = 2;
  b2.next = &b3;
  b3.data = 9;
  b3.next = NULL;
    
  //result = addition_rec(&a1,&b1,0);
  
  result = addition_iter(&a1, &b1);
 
  while (result != NULL) {
    printf("\n%d", result->data);
    result = result->next;
  }
}
