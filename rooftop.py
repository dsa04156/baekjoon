# N = int(input())

# cnt =0
# b_h= []
# for x in range(N):
#     b_h.append(int(input()))


# for i in range(N):
#     for j in range(i+1,N):
#         if b_h[i] >b_h[j]:
#             cnt += 1
#         elif b_h[i] < b_h[j]:
#             break

#     if i == N-1:
#         break

# print(cnt)

n = int(input())
arr = []
for x in range(n):
    arr.append(int(input()))
stk = []
result = 0

for i in range(n):
    while stk and stk[-1] <= arr[i]:
        stk.pop()
    stk.append(arr[i])
    result += len(stk) - 1

print(result)

