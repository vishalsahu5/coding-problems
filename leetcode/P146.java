class LRUCache {
  private LinkedList<Integer> dq;
  private HashMap<Integer, Integer> cache;
  private int size;

  public LRUCache(int capacity) {
    cache = new HashMap<>();
    dq = new LinkedList<>();
    size = capacity;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    } else {
      dq.remove(key);
      dq.addFirst(key);
      System.out.println(dq);
      return cache.get(key);
    }
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      get(key);
      cache.put(key, value);
    } else {
      if (cache.size() == size) {
        int removedKey = dq.removeLast();
        cache.remove(removedKey);
      }
      cache.put(key, value);
      dq.addFirst(key);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */