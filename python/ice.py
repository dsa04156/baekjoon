import sys
sys.setrecursionlimit(10**4)

def ice():
    ic =0
    for i in range(N):
        for j in range(M):
            c=0
            while(c<4):
                if -1<dx[c]+i<N and -1<dy[c]+j<M and arr[i][j] !=0:
                    if arr[dx[c]+i][j]==0:
                        brr[i][j] -=1
                        c+=1
                    elif arr[i][dy[c]+j]==0:
                        brr[i][j] -=1
                        c+=1
                    else:
                        c+=1
                else:
                    c+=1
            if brr[i][j] <0:
                brr[i][j]=0
    for i in range(N):
        for j in range(M):
            arr[i][j]=brr[i][j]
    for i in range(N):
        for j in range(M):
            if brr[i][j]!=0:
                crr[i][j] = 1
    
            
            


def dfs(x,y):
    v[x][y]=1
    num = crr[x][y]

    for i in range(4):
        nx = x+dx[i]
        ny = y + dy[i]
        if 0<=nx<N and 0<= ny<M:
            if v[nx][ny] == 0:
                if crr[nx][ny] == num:
                    dfs(nx,ny)
        




dx = [1,-1,0,0]
dy = [0,0,1,-1]
global N,M
global arr,brr,v,crr
N, M = map(int,input().split())
arr = [list(map(int,input().split())) for i in range(N)]
brr = [[0 for i in range(M)]for j in range(N)]


for i in range(N):
    for j in range(M):
        brr[i][j] = arr[i][j]

cnt=0
year=0

while cnt<2:
    t=0
    l=1
    cnt=0
    crr = [[0 for i in range(M)]for j in range(N)]
    v = [[0 for i in range(M)]for j in range(N)]
    ice()
    for i in range(N):
        for j in range(M):
            if v[i][j] == 0 and  crr[i][j]==1:
                dfs(i,j)      
                cnt+=1
    if cnt==0:
        break
    year+=1

      

if cnt==0:
    print(0)
else:
    print(year)




