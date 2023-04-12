dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def snail():
    x = 0
    y = 0
    direction = 0
    for p in range(N * N):
        snail_arr[x][y] = p + 1
        x += dx[direction]
        y += dy[direction]

        if 0 <= x < N and 0 <= y < N and not snail_arr[x][y]:
            continue
        else:
            x -= dx[direction]
            y -= dy[direction]

            direction = (direction + 1) % 4

            x += dx[direction]
            y += dy[direction]


T = int(input())

for t in range(T):
    N = int(input())
    snail_arr = [[0 for _ in range(N)] for _ in range(N)]
    direction = 0
    snail()

    print(f'#{t + 1}')
    for i in snail_arr:
        print(*i)
