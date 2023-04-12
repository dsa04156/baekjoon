T = int(input())
cnt = 1
for i in range(T):
    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    C = []

    if N>M:
        D = N - M + 1
        for t in range(D):
            sum=0
            for j in range(len(B)):
                sum = sum + A[j]*B[j]
            B.insert(0,0)
            C.append(sum)
    else:
        D = M - N + 1
        for y in range(D):
            sum = 0
            for u in range(len(A)):
                sum = sum + A[u]*B[u]
            C.append(sum)
            A.insert(0, 0)
    print("#{0} {1}".format(cnt,max(C)))
    cnt += 1

