class Deque:
	def __init__(self):
		self.items = []

	def add_front(self,item):
		"""takes an item as an parameter and insert it into the 0th 
		index if the list that is represting the Deque

		The runtime is O(n) or linear, because everytime you insert an
		into the front of the list remaining items in the list shift one 
		position to the right"""

		self.items.insert(0, item)

	def add_rear(self,item):
		"""takes an item as an parameter and insert it into the end 
		index if the list that is represting the Deque

		The runtime is O(1), constant time because appending an item
		happens in constant time"""

		self.items.append(item)	

	def remove_front(self):
		"""Removes and returns the item in the 0th index of the list,
		which represents the front of the Deque

		Runtime is linear, or O(n) becuase when we remove an items from
		the 0th index, all the other items have to shift one index to 
		the left"""
		
		if self.items:
			return self.items.pop(0)
		return None

	def remove_rear(self):
		"""Removes and returns the last item in list, which represents 
		the rear of the Deque

		Runtime is constant, or O(1) becuase all we're doing is indexing
		to the end of the list"""
		
		if self.items:
			return self.items.pop()
		return None

	def peek_front(self):
		"""Return the 0th item in the list which represent the front of 
		Deque

		Runtime is constant, or O(1) as we are just returning the first
		element in the list"""
		
		if self.items:
			return self.items[0]
		return None

	def peek_rear(self):
		"""Return the -1st, last item in the list which represent the front of 
		Deque.

		Runtime is constant, or O(1) as we are just returning the last
		element in the list"""

		if self.items:
			return self.items[-1]
		return None
	
	def size(self):
		"""Return the size of the list representing the Deque

		The Runtime is O(1) as lenght function takes constant time"""

		return len(self.items)

	def is_empty(self):
		"""Returns a boolean value describing Deque is empty or not.

		Testing for equalty happens in constant time, hence runtime is O(1)
		"""

		return self.items == []

# Check palindrom function, implemented using Deque data structure
def checkPalindrome(input_str):

	myD = Deque()
	for char in input_str:
		myD.add_rear(char)

	while myD.size() >= 2:
		front_item = myD.remove_front()
		rear_item = myD.remove_rear()

		if front_item != rear_item:
			print("The input String is not a palindrom.")
			return 

	print("The input String is a palindrom.")

# Run the test case
inputString = input("Enter the string to be tested - ")
checkPalindrome(inputString)
