#include<stdio.h>

struct node
{
  int data;
  struct node *next;
};

struct node * check_list(struct node *head)
{
  struct node *s1;
  struct node *s2;
  
  s1 = head;
  s2 = head->next->next;
  
  while(s1 != s2)
  {
    s1=s1->next;
    s2=s2->next->next;
    if(s2 == NULL )
      break;
  }
  
  s1=head;
  while(s1 != s2)
  {
    s1 = s1->next;
    s2 = s2->next;
  }
  
  return s1;
}

int main()
{
  struct node a1,a2,a3;
  struct node *temp;
  
  a1.data = 1;
  a2.data = 2;
  a3.data = 3;
  
  a1.next = &a2;
  a2.next = &a3;
  a3.next = &a2;
  
  temp = check_list(&a1);
  
  printf("data : %d",temp->data);
}
