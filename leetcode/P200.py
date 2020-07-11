def dfs(grid, x, y):
    if (0 <= x < len(grid)) and (0 <= y < len(grid[0])) and grid[x][y] == "1":
        grid[x][y] = -1
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        for dir in dirs:
            newX = dir[0] + x
            newY = dir[1] + y
            dfs(grid, newX, newY)


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    dfs(grid, i, j)
                    count += 1
        return count
