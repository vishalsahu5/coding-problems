from queue import PriorityQueue


def peek(pq):
    return pq.queue[0]


def findKLargest(lst, k):
    q = PriorityQueue()
    for num in lst:
        if q.qsize() < k:
            q.put(num)
        else:
            if peek(q) < num:
                q.get()
                q.put(num)
    result = []
    while not q.empty():
        result.append(q.get())
    result.reverse()
    return result
