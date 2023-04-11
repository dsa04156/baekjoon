import sys

T = int(sys.stdin.readline())

for i in range(T):
    dict = {}
    n = int(sys.stdin.readline())

    
    a_list = [int(x) for x in sys.stdin.readline().split()]

    for i in range(n):
        dict[i+1] = a_list[i]
    di = dict
    print(di)
    cnt=0
    for i in range(1,n+1):

        c=0
        b = i
        while(True):
            a = dict[b]
            if dict[a] == b:
                cnt +=1
                print(dict[a],dict[b])
                di.pop(a)
                di.pop(b)
                break
            else:
                di.pop(b)
                b=a
                c+=1
                if c>n-1:
                    break
        if 
        continue
        
                
    print(n - cnt)
