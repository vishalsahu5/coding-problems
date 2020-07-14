from queue import PriorityQueue


class Custom:
    def __init__(self, value):
        self.value = value[:]

    def __lt__(self, obj):
        """self < obj."""
        if self.value[0] == obj.value[0]:
            return (self.value[1] > obj.value[1])
        return (self.value[0] < obj.value[0])


class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        counts = {}

        for word in words:
            if word not in counts:
                counts[word] = 1
            else:
                counts[word] += 1

        q = PriorityQueue()

        for key, value in counts.items():
            if q.qsize() < k:
                q.put(Custom([value, key]))
            else:
                top = q.queue[0].value
                if top[0] < value or top[0] == value and top[1] > key:
                    q.get()
                    q.put(Custom([value, key]))

        result = []
        while q.qsize() > 0:
            # print(q.queue[0].value)
            result.append(q.get().value[1])

        return reversed(result)
