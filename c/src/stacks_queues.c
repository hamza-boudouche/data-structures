#include "structures.h"
#include "functions.c"

void empiler(List *pile, int newData){
    addNode(pile, newData);
}

int depiler(List *pile){
    int i = pile->head->data;
    delNode(pile);
    return i;
}

void enfiler(List *file, int newData){
    addNodep(file, newData, file->lenght);
}

void defiler(List *file){
    int i = file->head->data;
    delNode(file);
    return i;
}
