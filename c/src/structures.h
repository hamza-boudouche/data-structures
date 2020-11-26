#include <stdlib.h>
#ifndef structures
#define structures



typedef struct List List;
struct List
{
    int lenght;
    void *head;
};

typedef struct Node Node;
struct Node
{
    int data;
    void *next;
};

//staks and queues will be implemented using linked lists; no additionnal structures will be defined.

#endif
