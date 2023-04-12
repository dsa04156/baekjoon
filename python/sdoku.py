import sys

sys.stdin = open("input.txt", "r")

T = int(input())


def hang():
    row_list = []
    for x in range(N):
        for y in range(N):
            row_list.append(N_list[y][x])
        row_list = set(row_list)
        row_list = list(row_list)
        if len(row_list) == 9:
            row_list.clear()
            res =1
            continue
        else:
            res = 0
            break
    return res


def yul():
    cel_list = []
    for x in range(N):
        if len(N_list[x]) != 9:
            res=0
            break
        for y in range(N):
            cel_list.append(N_list[x][y])
        cel_list = set(cel_list)
        cel_list = list(cel_list)
        if len(cel_list) == 9:
            cel_list.clear()
            res=1
            continue
        else:
            res = 0
            break
    return res


def square():
    square_list = []
    for n in range(1, 4):
        for x in range((n - 1) * 3, 3 * n):
            for y in range((n - 1) * 3, 3 * n):
                square_list.append(N_list[x][y])
        square_list = set(square_list)
        square_list = list(square_list)
        if len(square_list) == 9:
            res = 1
            square_list.clear()
        else:
            res = 0
            break
    return res


for i in range(T):
    N = 9
    N_list = [list(map(int, input().split())) for _ in range(N)]
    N_list = list(map(set, N_list))
    N_list = list(map(list, N_list))

    a = hang()
    b = yul()
    c = square()
    if a == b == c ==1:
        res =1
    else:
        res =0
    print("#{} {}".format(i+1,res))
