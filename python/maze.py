N,M = map(int,input().split())
# maze = [list(map(int,input())) for i in range(N)]
maze = []
for _ in range(N):
  maze.append(list(map(int, input())))


dx = [1,-1,0,0]
dy = [0,0,1,-1]
a,b,c = 0,0,0
cnt = 1
w_c = 0
while True:
    if a + dx[c] <N and b+dy[c]<M and a+dx[c]>=0 and b + dy[c]>=0 and maze[a+dx[c]][b+dy[c]] == 1:
        maze[a+dx[c]][b+dy[c]] =0
        pre_a=a
        pre_b=b
        a += dx[c]
        b += dy[c]
       
        cnt += 1
        w_c = 0
    
    elif a + dx[c]>=N or b + dy[c]>=M or a+dx[c]<0 or b + dy[c]<0 or maze[a+dx[c]][b+dy[c]] == 0:
        c += 1
        if c >= 4:
            c %= 4
        w_c +=1
        if w_c>3:
            maze[a][b] = 0
            a= pre_a
            b = pre_b
            c+=1
            cnt-=1
            if c>4:
                c %=4
            w_c=0


    if a == N-1 and b == M-1:
        break
    
print(cnt)
