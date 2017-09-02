class node:

    def __init__(self,page):
        self.page = page 
        self.next = None
        self.prev = None


class lru:

    def __init__(self,capacity):
        self.head = None
        self.tail = None
        self.capacity = capacity
        self.size = 0
        self.faults_count = 0
        self.map = {} 

    def read(self,arr):
        #return number of page faults

        for i in range(len(arr)):
            cache.insert(arr[i])
            
        return self.faults_count


    def insert(self,page):
        #page is a string 

        if(page in self.map): # page is already there in the buffer
            print(page,"is in the buffer")
            curr = self.map[page]
            if(self.head is curr): # if the referenced page is at head,remove it from head and place it at the tail
                self.head = self.head.next
                curr.next = None
                curr.prev = self.tail
                self.tail.next = curr
                self.tail = self.tail.next

            elif(self.tail is curr): #if the references page is already at the tail, no need to do anything
                pass

            else: #if the referenced page is in between head and tail
                curr.prev.next = curr.next
                curr.next.prev = curr.prev
                curr.next = None
                curr.prev = self.tail
                self.tail.next = curr
                self.tail = self.tail.next


        else: # page was not in the buffer and we will need to take out the least recently used.
            self.faults_count += 1 
            print(page,"is not in the buffer,","faults =",self.faults_count)
            if(self.size == 0): #when the first element was inserted
                newNode = node(page)
                newNode.next = None
                newNode.prev = None
                self.map[page] = newNode
                self.head = newNode
                self.tail = newNode
                self.size = self.size + 1


            elif(self.size < self.capacity): # when still the buffer was not fully used
                newNode = node(page)
                newNode.next = None
                newNode.prev = self.tail
                self.map[page] = newNode
                self.tail.next = newNode
                self.tail = self.tail.next
                self.size += 1 

            else: #after the full buffer has been used
               #first remove the least recently used i.e head and then 
               #add the new node to the tail
               head_page = self.head.page
               print("removing:",head_page,"from the cache,replacing it with:",page)
               self.head = self.head.next
               self.head.prev = None
               del self.map[head_page]

               #now add the new node to the tail of the dll

               newNode = node(page)
               newNode.next = None
               newNode.prev = self.tail
               self.map[page] = newNode
               self.tail.next = newNode
               self.tail = self.tail.next

if(__name__ == "__main__"):
    print("Enter the capacity of buffer/cache")
    n = int(input())
    cache = lru(n)
    arr = input("Enter the pages as space separated\n").split(" ")
    print("number of page faults:",cache.read(arr))

