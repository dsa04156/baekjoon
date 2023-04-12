T = int(input())
cnt = 1
for i in range(T):
    a = list(str(input()))
    b = []
    for j in range(len(a)):
        b.append(a[len(a)-j-1])
    if a == b:
        print("#{0} {1}".format(cnt,1))
    else:
        print("#{0} {1}".format(cnt,0))
    cnt +=1
