import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for i in range(T):
    sum_list = []
    N, M = map(int,input().split())
    N_list = [list(map(int,input().split()))for _ in range(N)]
    for p in range(N-1):
        for q in range(N-1):
            sum = 0
            for m in range(M):
                for n in range(M):
                    if p+m < N and q+n <N:
                        sum += N_list[p+m][q+n]
            sum_list.append(sum)

    a = max(sum_list)
    print("#{0} {1}".format(i+1,a))