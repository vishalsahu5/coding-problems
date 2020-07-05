def find_product(lst):
    A = [1] * len(lst)
    for i in range(1, len(lst)):
        A[i] = A[i-1] * lst[i-1]

    B = [1] * len(lst)
    for i in range(len(lst)-2, -1, -1):
        B[i] = B[i+1] * lst[i+1]

    for i in range(len(lst)):
        B[i] = A[i] * B[i]

    return B
