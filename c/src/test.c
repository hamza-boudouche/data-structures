#include <stdio.h>
#include <string.h>

int test(void);

int main()
{
      int a = 0;
      int b = test();
      printf("%d", b);
      return 0;
}  

int test(){
      return a;
}