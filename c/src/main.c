#include <stdio.h>
#include <stdlib.h>
#include "hello.c"


int main()
{
	printf("Hello World");
	List l = {2, NULL};
	printf("%d", l.lenght);
	return 0;
}
