#include <stdlib.h>

typedef struct List List;
struct List
{
    int lenght;
    Node *head;
};

typedef struct Node Node;
struct Node
{
    int data;
    Node *next = NULL;
};
