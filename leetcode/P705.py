class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.store = []
        self.prime = 101
        for i in range(self.prime):
            self.store.append([])
        
        
    def __gethash(self, key: int) -> int:
        return int(key % self.prime)

    def add(self, key: int) -> None:
        idx = self.__gethash(key)
        if not self.contains(key):
            self.store[idx].append(key)

    def remove(self, key: int) -> None:
        idx = self.__gethash(key)
        if self.contains(key):
            self.store[idx].remove(key)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        idx = self.__gethash(key)
        return (key in self.store[idx])
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)