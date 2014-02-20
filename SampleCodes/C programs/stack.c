#include <stdio.h>

struct node
{
    int data;
    struct node *prev;
}
struct stack
{
  struct node *top;
  int size;
}

int stack_init(struct stack *s)
{
    s->top = NULL;
    s->size = 0;
}

void stack_push(struct stack *s, struct node *n )
{
   if(s->top == NULL)
   {
      s->top = n;
      s->top->prev = NULL;
      s->size++;
   }
   else
   {
      n->prev = s->top;;
      s->top = n;
      s->size++;
   }
}
