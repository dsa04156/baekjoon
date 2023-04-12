T = int(input())
for p in range(T):

    N, K = map(int,input().split())
    T = [list(map(int,input().split())) for i in range(N)]
    cnt =0
    res = 0
    for x in range(N):
        for y in range(N):
            if T[x][y]==1:
                cnt += 1
            if T[x][y] == 0 or y == N -1:
                if cnt == K:
                    res +=1
                cnt = 0
    for x in range(N):
        for y in range(N):
            if T[y][x] == 1:
                cnt += 1
            if T[y][x] == 0 or y == N-1:
                if cnt == K:
                    res +=1
                cnt=0
    print("#{0} {1}".format(p+1,res))

