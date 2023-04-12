T = int(input())
cnt = 1
for i in range(T):
    P, Q, R, S, W = map(int,input().split())
    A = P * W
    if W <= R:
        B = Q
    else:
        B = Q + ((W-R)*S)

    if A < B:
        print("#{0} {1}".format(cnt,A))
    else:
        print("#{0} {1}".format(cnt,B))
    cnt+=1


