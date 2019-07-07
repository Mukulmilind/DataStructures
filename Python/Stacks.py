class Stack:
	def __init__(self):
		self.items = []

	def push(self,item):
		""" Accepts an item and appends it to the end of the list, meaning top of the stack.
		Returns Nothing 
		
		The runtime for this method is O(1), or constant time, because appending to the end 
		of the list is happens in constant time.
		"""

		self.items.append(item)

	def pop(self):
		"""Remove and Return the last item from the list that is also the top item of the stack

		The rumtime is also constant time, because all it does is index to the last item of the list
		"""
		if self.items:
			return self.items.pop()
		
		return None

	def peek(self):
		"""Return the last item from the list that is also the top item of the stack

		The rumtime is also constant time, because all it does is index to the last item of the list
		"""
		if self.items:
			return self.items[-1]

		return None

	def size(self):
		""" Return the length of the stack
		The runtime of O(1) which is a constant"""
		
		return len(self.items)

	def isEmpty(self):
		"""This method returns a boolean value describing stack is empty or not

		Testing for equalty happens in constant time, hence runtime is O(1)"""
		
		if self.items:
			return False
		else:
			return True
def checkEquality(inputSymbols):
	
	symbol_pair = {'{':'}','[':']','(':')'}
	openers=symbol_pair.keys()
	
	my_stack=Stack()
	symbols=list(inputSymbols)

	for symbol in symbols:
		if symbol in openers:
			my_stack.push(symbol)
		else:
			if my_stack.isEmpty():
				return False
			else:
				poppedItem=my_stack.pop()
				if symbol != symbol_pair[poppedItem]:
					return False

	if my_stack.isEmpty():
		return True
	else:
		return False

testString=input("Enter the input symbol to be balanced : ")

result=checkEquality(testString)
if result:
	print("Input Symbols are balanced")	
else:
	print("Input Symbols are not balanced")


