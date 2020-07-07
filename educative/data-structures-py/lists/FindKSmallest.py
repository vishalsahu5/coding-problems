from queue import PriorityQueue


class MyInt(int):
    def __lt__(self, other):
        return self > other


def peek(pq):
    return pq.queue[0]


def findKSmallest(lst, k):
    q = PriorityQueue()
    for i in range(len(lst)):
        if (q.qsize() < k or peek(q) > lst[i]):
            if (q.qsize() == k):
                q.get()
            q.put(MyInt(lst[i]))

    result = []
    while not q.empty():
        result.append(q.get())
    result.reverse()
    return result
