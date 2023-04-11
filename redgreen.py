import sys
sys.setrecursionlimit(1000000)

N = int(input())
arr = [list(map(str,input())) for i in range(N)]
visited = [[False] * N for i in range(N)]
cnt = 0
c_cnt = 0 
dx = [1,-1,0,0]
dy = [0,0,1,-1]


def dfs(x,y):
    visited[x][y] = True
    color = arr[x][y]

    for i in range(4):
        nx = x+dx[i]
        ny = y + dy[i]
        if 0<=nx<N and 0<= ny<N:
            if visited[nx][ny] == False:
                if arr[nx][ny] == color:
                    dfs(nx,ny)

for i in range(N):
    for j in range(N):
        if visited[i][j] == False:
            dfs(i,j)
            cnt +=1

for i in range(N):
    for j in range(N):
        if arr[i][j] == 'R':
            arr[i][j] = 'G'

visited = [[False] * N for i in range(N) ]
for i in range(N):
    for j in range(N):
        if visited[i][j] == False:
            dfs(i,j)
            c_cnt +=1

print(cnt,c_cnt)