class node:

    def __init__(self,val):
        self.val = val #this will be an integer for our example
        self.next = None
        self.prev = None


class lru:

    def __init__(self,capacity):
        self.head = None
        self.tail = None
        self.capacity = capacity
        self.size = 0
        self.faults_count = 0
        self.map = {} # map  from integer to node


    def insert(self,page):
        #page is an interger

        if(page in self.map):
        


        else:

