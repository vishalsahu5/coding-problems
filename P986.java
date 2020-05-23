class Pair { 
  int a, b;
  Pair(int a, int b) {
      this.a = a;
      this.b = b;
  }
}

class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
      ArrayList<Pair> arr = new ArrayList<Pair>();
      
      int i = 0; 
      int j = 0; 
      
      while(i < A.length && j < B.length) {
          int l = Math.max(A[i][0] , B[j][0]); 
          
          int r = Math.min(A[i][1], B[j][1]);  
          if (l <= r) {
              arr.add(new Pair(l, r)); 
          }
          
          if (A[i][1] < B[j][1]) i++; 
          
          else j ++;
      }
      int[][] ans = new int[arr.size()][2];
      
      for (i = 0; i < arr.size(); ++i) {
          ans[i][0] = arr.get(i).a;
          ans[i][1] = arr.get(i).b;
      }
      
      return ans;
  }
}