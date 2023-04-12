l = 1

def qq(n,m):
    global res
    global i
    global l
    res *= n
    i+=1
    if i == m:
        print("#{} {}".format(l,res))
        l+=1
    else:
        qq(n,m)

for i in range(10):
    T = int(input())
    n,m = map(int,input().split())
    res = 1
    i = 0

    qq(n,m)

