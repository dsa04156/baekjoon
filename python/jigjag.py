T = int(input())
cnt = 1
for a in range(T):
    N = int(input())
    holsu = []
    jjacksu = []

    sum1 = 0
    while N > 0:
        if N % 2 == 1:
            holsu.append(N)
        elif N % 2 == 0:
            jjacksu.append(N)
        N -= 1
    for i in range(len(holsu)):
        sum1 += holsu[i]

    for j in range(len(jjacksu)):
        sum1 -= jjacksu[j]
    print("#{0} {1}".format(cnt,sum1))
    cnt +=1




