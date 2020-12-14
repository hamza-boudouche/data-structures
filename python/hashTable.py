from linkedLists import linkedList

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class HashTable:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0 #keep count of the size so that we can reAllocat memory when hashtable gets too full
        self.containers = [None] * self.capacity
    
    def hash(self, key): #simple hash function(key: string)
        hashsum = 0
        for index, char in enumerate(key):
            hashsum += (index + len(key)) ** ord(char) #ord(char) == ascii code of char
        hashsum %= self.capacity #fitting the result of hashsum in the lists lenght (capacity)
        return hashsum
    
    def insert(self, key, value): #insert key in the position relative to its hashsum
        hashsum = self.hash(key)
        node = self.containers[hashsum]
        if node == None: #no collision
            node = Node(key, value)
        else: #if collision, go to the end of the linked list
            while(node.next != None): #go to the end of the linkedList
                node = node.next
            node.next = Node(key, value)
        self.size += 1
    
    def find(self, key):
        hashsum = self.hash(key) #search node in position = hashsum
        current = self.containers[hashsum]
        while(current != None and current.key != key):
            current = current.next
        if current == None: #if the end of the list was reached then node does not belong to hashTable
            return False
        return current.value

    def del(self, key):
        hashsum = self.hash(key)
        node = self.containers[hashsum]
        prev = None #we need to keep track of the previous node because the list is simply linked(not required in doubly linked lists)
        while(node.key != key): #search for the node with the wanted key
            prev = node
            node = node.next
        prev.next = node.next #jump over the node with the wanted key
        self.size -= 1

    def printHashTable(self):
        for i in range(self.capacity):
            l = linkedList()
            node = self.containers[i]
            l.head = node
            l.printList()
