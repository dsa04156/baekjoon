N = int(input())
arr = [list(map(int, input().split())) for i in range(N)]

m = 0
z = 0
p = 0

def sol(x,y,n):
    global m,z,p
    arr2 = arr[x][y]    
    for i in range(x,x+n):
        for j in range(y,y+n):
            if  arr[i][j] != arr2:
                for k in range(3):
                    for l in range(3):
                        sol(x+k*n//3,y+l*n//3,n//3)
                return

    if  arr2 == -1:
        m +=1
    elif arr2 ==0:
        z+=1
    else:
        p+=1

sol(0,0,N)
print(m,z,p)


