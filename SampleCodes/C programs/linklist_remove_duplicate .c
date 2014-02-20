#include <stdio.h>
#include <stdlib.h>

struct linkedList
{
    char data;
    struct linkedList *next;
};

int removeDuplicate(struct linkedList *head)
{
  struct linkedList *previous = head;
  struct linkedList *current = previous->next;
  struct linkedList *runner;
  struct linkedList *temp;
  
  if(head == NULL)
  {
      return 0;
  }
  
  while(current != NULL)
  {
      runner = head;
      while(runner != current)
      {
          if(runner->data == current->data)
          {
              temp = current->next;
              previous->next = temp;
              current = temp;
              break;
          }
          runner = runner->next;
      }
      if(runner == current)
      {
          previous = current;
          current = current->next;
      }
  }
  
  return 1;
}

int main()
{
   struct linkedList l1,l2,l3,l4,l5,l6;
   
   l1.data = 'a';
   l1.next = &l2;
   l2.data = 'b';
   l2.next = &l3;
   l3.data = 'c';
   l3.next = &l4;
   l4.data = 'a';
   l4.next = &l5;
   l5.data = 'b';
   l5.next = NULL;
   
   removeDuplicate(&l1);
}
