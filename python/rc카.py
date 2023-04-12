T = int(input())
cnt = 1
for x in range(T):
    n = int(input())
    s,t,d =0,0,0

    for i in range(n):
        a_list = list(map(int,input().split()))
        if a_list[0] == 0:
            d = d + s
        elif a_list[0] == 1:
            s = a_list[1] + s
            d = d + s
        elif a_list[0] == 2:
            if s <= a_list[1]:
                s = 0
            else:
                s = s - a_list[1]
                d = d + s
        a_list.clear()

    print("#{0} {1}".format(cnt,d))
    cnt+=1


