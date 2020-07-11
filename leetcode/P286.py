from collections import deque


class Solution(object):
    def wallsAndGates(self, room):
        """
        :type rooms: List[List[int]]
        :rtype: None Do not return anything, modify rooms in-place instead.
        """
        q = deque()
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        visited = [[False] * len(room[0]) for i in range(len(room))]
        for i in range(len(room)):
            for j in range(len(room[0])):
                if room[i][j] == 0:
                    q.append([i, j])
                    visited[i][j] = True
        d = 1
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                for dir in dirs:
                    newX, newY = dir[0] + node[0], dir[1] + node[1]
                    if (0 <= newX < len(room) and
                        0 <= newY < len(room[0]) and
                        room[newX][newY] > 0 and
                            visited[newX][newY] == False):

                        visited[newX][newY] = True
                        room[newX][newY] = min(room[newX][newY], d)
                        q.append([newX, newY])
            d += 1
