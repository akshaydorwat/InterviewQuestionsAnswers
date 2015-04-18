#include <stdio.h>

int main(int argc, char *argv[])
{
  char a = 'A';
  char b = 'B';
  const char *const_char = &a;
  char *const const_ptr = &a;

  const_char = &b;
  const_ptr = &b;
  return 0;
}
