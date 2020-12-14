#include "structures.h"
#include <stdlib.h>
#ifndef functions
#define functions


//acts as a constructor of linkedList
List *init(){
    List *list = malloc(sizeof(List));

    if(list == NULL){
        exit(-1);
    }

    list->head = NULL;

    return list;
}

//add node in the first position in the linked list
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

//delete first node of linkedList
void delNode(List *list){
    if(list->lenght == 0){
        free(list);
    }

    Node *first = list->head;
    list->head = first->next;
    free(first);
    list->lenght--;
}

//delete list; free all nodes
void delList(List *list){
    while(list->lenght >= 0){
        delNode(list);
    }
}

void printList(List *list){
    if(list == NULL){
        exit(-1);
    }
    Node *current = list->head;
    printf("\n");
    while(current){
        printf("%d\t", current->data);
        current = current->next;
    }
}

//concatenate 2 linked listes
void llconcat(List *list1, List *list2){
    list1->lenght += list2->lenght; 
    Node *n1 = list2->head;
    Node *current = list1->head;
    while(current->next){
        current = current->next;
    }
    current->next = n1;
    free(list2);
}

//add node in a certain position
void addNodep(List *list, int newData, int position){
    Node *newNode = malloc(sizeof(Node));
    newNode->data = newData;
    if(position > list->lenght || newNode == NULL){
        exit(-1);
    }
    Node *current = list->head;
    int i = 0;
    while(i < position - 1){
        current = current->next;
        i++;
    }
    newNode->next = current->next;
    current->next = newNode;
    list->lenght++;
}

//delete node in a certain position
void delNodep(List *list, int position){
    if(position >= list->lenght){
        exit(-1);
    }
    Node *current = list->head;
    int i = 0;
    while(i < position - 1){
        current = current->next;
        i++;
    }
    Node *todelete = current->next;
    current->next = todelete->next;
    free(todelete);
    list->lenght--;
}

#endif
