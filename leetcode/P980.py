def dfs(grid, visited, i, j, count):
    if (0 <= i < len(grid)) and (0 <= j < len(grid[0])) and not visited[i][j] and grid[i][j] != -1:
        if (grid[i][j] == 2) and (count == -1):
            return 1
        
        visited[i][j] = True
        dirs = [[1,0], [0,1], [-1,0], [0, -1]]
        res = 0
        for x,y in dirs:
            new_i = i + x
            new_j = j + y
            res += dfs(grid, visited, new_i, new_j, count-1)
        visited[i][j] = False
        return res
    else:
        return 0

class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        visited = [[False]*len(grid[0]) for _ in range(len(grid))]
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (grid[i][j] == 0):
                    count += 1
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (grid[i][j]) == 1:
                    return dfs(grid, visited, i, j, count)
        
        return 0
            