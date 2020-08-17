class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals

        intervals.sort()
        result = []
        current_interval = intervals[0]

        for next_interval in intervals:
            current_low, current_high = current_interval
            next_low, next_high = next_interval

            if (current_high < next_low):
                result.append(current_interval)
                current_interval = next_interval
            else:
                current_interval[1] = max(current_high, next_high)

        result.append(current_interval)

        return result
