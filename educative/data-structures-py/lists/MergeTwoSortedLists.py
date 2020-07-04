def merge_lists(lst1, lst2):
    lst3 = []
    i, j = 0, 0
    while i < len(lst1) and j < len(lst2):
        if lst1[i] < lst2[j]:
            lst3.append(lst1[i])
            i += 1
        else:
            lst3.append(lst2[j])
            j += 1
    if i < len(lst1):
        lst3 += lst1[i:]
    if j < len(lst2):
        lst3 += lst2[j:]
    return lst3
