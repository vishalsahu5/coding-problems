public class Solution
{
  public int[] SortedSquares(int[] A)
  {

    int left = 0, right = 0;
    while (left < A.Length && A[left] < 0) left++;
    left--;
    right = left + 1;
    int[] result = new int[A.Length];
    int pos = 0;
    while (pos < A.Length && left >= 0 || right < A.Length)
    {
      if (right == A.Length || left >= 0 && A[left] * A[left] < A[right] * A[right])
      {
        result[pos++] = A[left] * A[left];
        left--;
      }
      else
      {
        result[pos++] = A[right] * A[right];
        right++;
      }
    }
    return result;
  }
}