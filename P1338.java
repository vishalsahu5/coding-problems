class Solution {
    private class Pair{
        public Integer first;
        public Integer second;
        public Pair(int i, int j) {
            first = i;
            second = j;
        }
        
        public String toString() {
            return "[ "+first.toString()+" , "+second.toString()+" ]";
        }
    }
    
    public int minSetSize(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o2.second > o1.second) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        Arrays.sort(arr);
        int count = 1;
        int i=1;
        do {
            if (arr[i] != arr[i-1]) {
                pq.add(new Pair(arr[i-1], count));
                count = 1;
            } else {
                count++;
            }
            i++;
        } while (i < arr.length);
        if (count > 1)
            pq.add(new Pair(arr[i-1], count));
        int sum = 0;
        int result = 0;
        while (pq.size() > 0 && sum < arr.length/2) {
            sum += pq.poll().second;
            result++;
        }
        return result;
    }
}