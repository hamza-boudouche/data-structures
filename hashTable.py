from linkedLists import linkedList

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class HashTable:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.containers = [None] * self.capacity
    
    def hash(self, key):
        hashsum = 0
        for index, char in enumerate(key):
            hashsum += (index + len(key)) ** ord(char)
        hashsum %= self.capacity
        return hashsum
    
    def insert(self, key, value):
        hashsum = self.hash(key)
        node = self.containers[hashsum]
        if node == None:
            node = Node(key, value)
        else:
            while(node.next != None):
                node = node.next
            node.next = Node(key, value)
        self.size += 1
    
    def find(self, key):
        hashsum = self.hash(key)
        current = self.containers[hashsum]
        while(current != None and current.key != key):
            current = current.next
        if current == None:
            return False
        return current.value

    def del(self, key):
        hashsum = self.hash(key)
        node = self.containers[hashsum]
        prev = None
        while(node.key != key):
            prev = node
            node = node.next
        prev.next = node.next
        self.size -= 1
    
    def printHashTable(self):
        for i in range(self.capacity):
            l = linkedList()
            node = self.containers[i]
            l.head = node
            l.printList()
