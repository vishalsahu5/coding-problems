class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
       while(k > 0) {
            int item = pq.poll();
            if (k == 1) {
                return item;
            }
            k--;
        }
        return 0;
    }
}
// 1 2 2 3 3 4 5 5 6