from itertools import islice

def nList(L, N):
    ans = []
    for i in range(3):
        ans.append(list(islice(L, i, None, 3)))
    return ans