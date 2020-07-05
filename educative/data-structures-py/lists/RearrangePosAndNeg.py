def rearrange(lst):
    return [num for num in lst if num < 0] + [num for num in lst if num >= 0]
