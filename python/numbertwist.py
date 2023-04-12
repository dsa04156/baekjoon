T = int(input())

for i in range(T):
    N = int(input())
    N_list = [list(map(int,input().split())) for j in range(N)]
    T_list = [[0 for _ in range(3)]for _ in range(N)]

    for x in range(N):
        sum = 0
        for y in range(N):
            sum += N_list[N-y-1][N-x-1]*10**(N-y-1)
        T_list[N-x-1][0] = sum

    for a in range(N):
        sum = 0
        for b in range(N):
            sum += N_list[N-1-a][N-1-b]*10**(N-b-1)
        T_list[a][1]=sum

    for c in range(N):
        sum = 0
        for d in range(N):
            sum += N_list[d][N-1-c] * 10 ** (N - d - 1)
        T_list[c][2] = sum
    for x in range(N):
        for y in range(3):
            if len(str(T_list[x][y])) < N+1:
                T_list[x][y] = str(T_list[x][y])

    print("#{0}".format(i + 1))

    for d in range(N):
        for e in range(3):
            print(T_list[d][e].zfill(N) , end = " ")
        print()
