def right_rotate(lst, n):
    n = n % len(lst)
    result = [1]*len(lst)
    for i in range(len(lst)):
        result[(i+n) % len(lst)] = lst[i]
    return result
