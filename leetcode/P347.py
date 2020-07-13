import queue


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        pq = queue.PriorityQueue()
        freq = {}
        for num in nums:
            if num in freq:
                freq[num] += 1
            else:
                freq[num] = 1

        for key in freq.keys():
            value = freq[key]
            if pq.qsize() < k:
                pq.put([value, key])
            else:
                if pq.queue[0][0] < value:
                    pq.get()
                    pq.put([value, key])

        result = []
        while pq.qsize() > 0:
            result.append(pq.queue[0][1])
            pq.get()
        result.reverse()
        return result
