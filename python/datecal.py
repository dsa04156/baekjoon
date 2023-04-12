T = int(input())
days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
cnt =1
for i in range(T):
    m1,d1,m2,d2 = map(int,input().split())
    ans = 0

    if m1 ==m2:
        ans = d2-d1+1
    else:
        ans = days[m1] - d1 +1
        for i in range(m1+1,m2):
            ans += days[i]
        ans += d2
    print("#{0} {1}".format(cnt,ans))
    cnt +=1