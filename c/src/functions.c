#include "structures.h"
#include <stdlib.h>


List *init(){
    List *list = malloc(sizeof(List));

    if(list == NULL){
        exit(-1);
    }

    list->head = NULL;

    return list;
}

void addNode(List *list, int newData){
    Node *newNode = malloc(sizeof(Node));
    
    if(newNode == NULL){
        exit(-1);
    }

    newNode->data = newData;
    newNode->next = list->head;

    list->head = newNode;

    list->lenght++;
}

void delNode(List *list){
    if(list->lenght == 0){
        free(list);
    }

    Node *first = list->head;
    list->head = first->next;
    free(first);
    list->lenght--;
}

void delList(List *list){
    while(list->lenght >= 0){
        delNode(list);
    }
}
