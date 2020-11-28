class node:
    def __init__(self, data, next=None):    #next is initialised to None when ommited, useful when adding node to the end of the LL (Linked List)
        self.data = data
        self.next = next    #pointer to node

class linkedList:
    def __init__(self):
        self.head = None    # the first node is initialised to None
        self.lenght = 0     # ++ when calling add methode
    
    def add(self, data):    # adds node in the end of LL
        newNode = node(data)
        if self.head == None:
             self.head = newNode
        else:
            current = self.head
            while(current.next):
                current = current.next
            #current is None at end of while loop
            current.next = newNode
        self.lenght += 1
    
    def printList(self): 
        if(self.head):
            current = self.head
            while(current):
                print(current.data, end="\t")
                current = current.next
            print("\n")
        else:
            print("None")
    
    def addNode(self, data, position):     #adds node in the specified position
        newNode = node(data)
        i = 0   # counter to keep track of number of preceeding nodes
        current = self.head
        if self.lenght <= position:
            print("invalide operation")
        while(i < position):
            current = current.next
            i += 1
        #current is None at end of while loop
        #insert newNode using the next 2 lignes of code
        newNode.next = current.next
        current.next = newNode
    
    def LLConcat(self, list):
        newNode = list.head
        current = self.head
        while(current):
            current = current.next
        #current is None at end of while loop
        current.next = newNode
    
    def delNode(self, position):   #delets node in specified position 
        i = 0   # counter to keep track of number of preceeding nodes
        preceeding = None
        current = self.head
        if self.lenght <= i:
            print("invalide operation")
        while(i < position):
            preceeding = current
            current = current.next
            i += 1
        preceeding = current.next   # skip node in specified position 

    def find(self, data):
        current = self.head
        while(current != None):
            if current.data == data:
                return True
        return False





