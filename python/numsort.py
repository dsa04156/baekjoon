T = int(input())
cnt = 0
for i in range(T):
    N = int(input())
    N_list = list(map(int,input().split()))
    N_list.sort()
    print(N_list)
    cnt+=1
    print("#{0}".format(cnt), end=" ")
    for j in range(N):
        print("{0}".format(N_list[j]), end = " ")
    print()
