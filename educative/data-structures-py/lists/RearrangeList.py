def max_min(lst):
    result = []
    i, j = 0, len(lst)-1
    while i < j:
        result.append(lst[j])
        result.append(lst[i])
        i += 1
        j -= 1
    if i == j:
        result.append(lst[i])
    return result
