
def dfs(grid, x, y):
    if (x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == 0):
        return 1
    if grid[x][y] == -1:
        return 0

    grid[x][y] = -1

    dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    result = 0
    for diff in dirs:
        newX, newY = x + diff[0], y + diff[1]
        result += dfs(grid, newX, newY)
    return result


class Solution:

    def islandPerimeter(self, grid: List[List[int]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return dfs(grid, i, j)
        return 0
