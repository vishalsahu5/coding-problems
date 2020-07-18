from collections import deque


class Solution:

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        q = deque()
        indegree = [0]*numCourses
        adj = {}

        for i in range(len(prerequisites)):
            a, b = prerequisites[i][0], prerequisites[i][1]
            indegree[a] += 1
            if b not in adj:
                adj[b] = []
            adj[b].append(a)

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        order = []
        while len(q) > 0:
            node = q.popleft()
            order.append(node)
            if node in adj:
                for neighbour in adj[node]:
                    indegree[neighbour] -= 1
                    if indegree[neighbour] == 0:
                        q.append(neighbour)
        return order if len(order) == numCourses else []
