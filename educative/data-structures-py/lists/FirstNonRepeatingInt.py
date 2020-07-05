def find_first_unique(lst):
    counts = {}
    for num in lst:
        if num in counts:
            counts[num] += 1
        else:
            counts[num] = 1
    for num in lst:
        if counts[num] == 1:
            return num
    return None
