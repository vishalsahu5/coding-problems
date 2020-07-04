def find_sum(lst, k):
    cache = set()
    for num in lst:
        if k - num in cache:
            return [k-num, num]
        else:
            if num not in cache:
                cache.add(num)
    return None
