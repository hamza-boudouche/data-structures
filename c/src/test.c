#include <stdio.h>
#include <string.h>

int main()
{
      char nom[5] ;
      gets(nom);
      for(int i = 0; i < 5; i++){
            printf("%c.\n", nom[i]);
      }
      printf("%c", nom[5]);

    return 0;
}  