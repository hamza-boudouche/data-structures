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

void printList(List *list){
    Node *current = list->head;
    while(current){
        printf("%d", current->data);
        current = current->next;
    }
}

void llconcat(List *list1, List *list2){
    Node *n1 = list2->head;
    Node *current = list1->head;
    while(current->next){
        current = current->next;
    }
    current->next = n1;
    free(list2);
}

void addNodep(List *list, int newData, int position){
    Node *newNode = malloc(sizeof(Node));
    if(position >= list->lenght){
        exit(-1);
    }
    Node *current = list->head;
    int i = 0;
    while(i < position){
        current = current->next;
        i++;
    }
    newNode->next = current->next;
    current->next = newNode;
}

void delNodep(List *list, int position){
    if(position >= list->lenght){
        exit(-1);
    }
    Node *current = list->head;
    int i = 0;
    while(i < position){
        current = current->next;
        i++;
    }
    Node *todelete = current->next;
    current->next = todelete->next;
    free(todelete);
}

