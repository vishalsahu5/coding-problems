def dfs(graph, node, path, result):
    if (node == len(graph)-1):
        result.append(path[:])
        return
    
    for neighbour in graph[node]:
        path.append(neighbour)
        dfs(graph, neighbour, path, result)
        path.pop(len(path)-1)
    
class Solution:
    
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        result = []
        path = [0]
        dfs(graph, 0, path, result)
        return result
        