class Solution
{
public:
    int search(vector<int> &A, int target)
    {
        int start = 0;
        int end = A.size() - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (A[mid] == target)
                return mid;
            else
            {
                if (A[mid] > target)
                {
                    if (A[mid] > A[end] && target <= A[end])
                    {
                        start = mid + 1;
                    }
                    else
                    {
                        end = mid - 1;
                    }
                }
                else
                {
                    if (A[mid] < A[start] && target >= A[start])
                    {
                        end = mid - 1;
                    }
                    else
                    {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
};