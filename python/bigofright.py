# N = int(input())
# arr = list(map(int,input().split()))
# brr = []
# for i in range(len(arr)):
#     for j in range(i+1,len(arr)):
#         if arr[i] < arr[j]:
#             brr.append(arr[j])
#             break
#         elif max(arr) == arr[i]:
#             brr.append(-1)
#             break
    
#     if i == N-1:
#         brr.append(-1)
#         break

# for i in range(len(brr)):
#     print(brr[i], end=' ')

N =4
arr = [3,5,2,7]
stk = arr

for i in range(N):
    a = stk.popleft()
    for j in range(N):
        