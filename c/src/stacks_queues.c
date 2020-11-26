#include "structures.h"
#include "functions.c"
#ifndef stacks_queues
#define stacks_queues


void empiler(List *pile, int newData){
    addNode(pile, newData);
}

int depiler(List *pile){
    Node *n = malloc(sizeof(Node));
    if(n == NULL){
        exit(-1);
    }
    n = pile->head;
    int i = n->data;
    delNode(pile);
    free(n);
    return i;
}

void enfiler(List *file, int newData){
    addNodep(file, newData, file->lenght);
}

int defiler(List *file){
    Node *n = malloc(sizeof(Node));
    if(n == NULL){
        exit(-1);
    }
    n = file->head;
    int i = n->data;
    delNode(file);
    free(n);
    return i;
}

#endif
