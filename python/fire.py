# import time
# start = time.time()
# # R,C = map(int,input().split())
# R = 4 
# C=4
# c=0
# d=0
# cnt = 1
# maze =  [list(map(str,input())) for i in range(R)]
# dx = [1,-1,0,0]
# dy = [0,0,1,-1]
# fire = [[0 for i in range(C)] for j in range(R)]
# # f_dx = [1,-1,0,0]
# # f_dy = [0,0,1,-1]
# for i in range(R):
#     for j in range(C):
#         if maze[i][j] == "J":
#             j_x = i
#             j_y = j
#             break


# while(True):
#     if dx[c]+j_x < 4 and dy[c] + j_y <4 and dx[c] + j_x >-1 and dy[c] + j_y >-1 and maze[j_x + dx[c]][j_y + dy[c]] == ".":
#         maze[j_x][j_y] = "."
#         j_x += dx[c]
#         j_y += dy[c]
#         maze[j_x][j_y] = "J"
#         cnt += 1
#         for i in range(R):
#             for j in range(C):
#                 if maze[i][j] == "F":
#                     f_x = i
#                     f_y = j
#                     if f_x +1 <4 and maze[f_x+1][f_y]== ".":
#                         fire[f_x+1][f_y] ="F"
#                     if f_x -1 >-1 and maze[f_x-1][f_y] == ".":
#                         fire[f_x-1][f_y] ="F"
#                     if  f_y+1<4 and maze[f_x][f_y+1] == ".":
#                         fire[f_x][f_y+1] ="F"
#                     if f_y -1 >-1 and maze[f_x][f_y-1] == ".":
#                         fire[f_x][f_y-1] ="F"
#                     # if f_x+f_f_ynd f_dy[d] + f_y <4 and f_x + f_y and f_dy[d] + f_y >-1 and maze[f_x + f_x][f_y_dy[d]] == ".":
#                     #     maze[f_f_yf_dy[d]+f_y] = "F"
#                     #     break
#         for i in range(R):
#             for j in range(C):
#                 if fire[i][j] == "F":
#                     maze[i][j] == "F"
#     else:
#         c +=1
#         if c>3:
#             c %= 4

#     if j_x == 0 or j_y == 0 or j_x == 3 or j_y == 3:
#         break
        
# print(cnt)
# print("time :", time.time() - start)

import sys
from collections import deque
input = sys.stdin.readline
 
def bfs():
    while f_queue:    # fire BFS
        x, y = f_queue.popleft()
 
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
 
            if 0 <= nx < R and 0 <= ny < C:
                if not f_visited[nx][ny] and graph[nx][ny] != '#':
                    f_visited[nx][ny] = f_visited[x][y] + 1
                    f_queue.append((nx, ny))
 
    while j_queue:    # jihoon BFS
        x, y = j_queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
 
            if 0 <= nx < R and 0 <= ny < C:
                if not j_visited[nx][ny] and graph[nx][ny] != '#':
                    if not f_visited[nx][ny] or f_visited[nx][ny] > j_visited[x][y] + 1:    # important code
                        j_visited[nx][ny] = j_visited[x][y] + 1
                        j_queue.append((nx, ny))
            else:
                return j_visited[x][y] + 1    # escape map
 
    return 'IMPOSSIBLE'    # not escape map
 
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
 
R, C = map(int, input().split())
graph = [list(input().strip()) for _ in range(R)]
f_queue, j_queue = deque(), deque()    # declare fire, jihoon queue
f_visited, j_visited = [[0] * C for _ in range(R)], [[0] * C for _ in range(R)]    # declare fire, jihoon visited
 
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'F':
            f_queue.append((i, j))
        elif graph[i][j] == 'J':
            j_queue.append((i, j))
print(bfs())