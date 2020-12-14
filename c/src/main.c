#include <stdio.h>
#include <stdlib.h>
#include "functions.c"
#include "stacks_queues.c"
#include "structures.h"


int main()
{
	//testing ...
	printf("Hello World \n");
	List *l = init();
	addNode(l, 4);
	addNode(l, 8);
	addNode(l, 2);
	delNode(l);

	printList(l);

	empiler(l, 10);
	empiler(l, 5);

	depiler(l);

	defiler(l);

	printList(l);

	List *l0 = init();
	addNode(l0, 1);
	addNode(l0, 2);
	addNode(l0, 3);

	llconcat(l, l0);

	printList(l);

	enfiler(l, 10);

	printList(l);


	return 0;
}
