#include <stdio.h>
#include <string.h>
#include <inttypes.h>

int is_add_on_same_page(void *add1, void *add2){
  uint64_t add_64_1 = (uint64_t) add1;
  uint64_t add_64_2 = (uint64_t) add2;
  uint64_t page_size;

  page_size = getpagesize();

  printf("page size : %"PRIu64"\n", page_size);
  printf("pointer address 1  : %"PRIu64"\n", add_64_1);
  printf("pointer address 2  : %"PRIu64"\n", add_64_2);

  if((add_64_1 /page_size) == (add_64_2/page_size)){
    printf("Addresses are on same page \n");
  }else{
    printf("Addresses are not on same page \n");
  }
}

int main (int argc, char **argv){
  int i = 1;
  char *a =  (char *)(int*)&i;
  
  if( *a  == 0x10 ){
    printf("little endiana");
  }
  
  is_add_on_same_page(a, a+1);

}
