import math
def trailingZeros(n):
	result=0
	primeFactor=5

	while (n/primeFactor >= 1):
		result = result + math.floor(n/primeFactor)
		primeFactor=primeFactor*5
	return result

res=trailingZeros(100)
print("The number of trailing Zeros in 100! is "+ str(res))
