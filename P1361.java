class Solution {
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
      
      int[] indegree = new int[n];
      
      for (int i=0; i<n; i++) {
          if (leftChild[i] != -1) {
              indegree[leftChild[i]]++;
          }
          if (rightChild[i] != -1) {
              indegree[rightChild[i]]++;
          }
      }
      
      // start verification
      int zeroIndegreeNodes = 0, rootNode = 0;
      for (int i=0; i<n; i++) {
          if (indegree[i] == 0) { 
              zeroIndegreeNodes++;
              rootNode = i;
          }
          if (indegree[i] > 1 || zeroIndegreeNodes > 1) return false;
      }
      if (zeroIndegreeNodes == 0) return false;
      
      // do a dfs
      boolean[] visited = new boolean[n];
      dfs(rootNode, leftChild, rightChild, visited);
      for (int i=0; i<n; i++) {
          if (!visited[i]) return false;
      }
      
      return true;
  }

  private void dfs(int root, int[] left, int[] right, boolean[] visited) {
      
      visited[root] = true;
      if (left[root] != -1) dfs(left[root], left, right, visited);
      if (right[root] != -1) dfs(right[root], left, right, visited);
      
  }
  
}