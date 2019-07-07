import random

class Queue:
	def __init__(self):
		self.items = []

	def enqueue(self,item):
		"""Takes in an item and insert it at the 0th item of the list
		this is representing Queue

		Runtime is O(n), linear time because iserting at 0th item of 
		the list forces all other items in the list to move one index 
		to the right.
		"""
		self.items.insert(0, item)

	def dequeue(self):
		""" Removes and returns last item of the list meaning from the
		front of the queue

		Runtime is O(1), constant time as popping an element from the list
		takes place in constant time
		"""
		if self.items:
			return self.items.pop()
		return None

	def peek(self):
		""" Returns last item of the list meaning from the front-most item
		of the queue

		Runtime is O(1), constant time as popping an element from the list
		takes place in constant time
		"""
		if self.items:
			return self.items[-1]
		return None		

	def size(self):
		"""Return the length of the list which is the size of the Queue
		Runtime is O(1), constant time 
		"""
		return len(self.items)

	def isEmpty(self):
		"""Returns a boolean value describing stack is empty or not

		Testing for equalty happens in constant time, hence runtime is O(1)
		Because it only checks for equality
		"""
		return self.items == []

class Job:
	def __init__(self):
		self.pages=random.randint(1, 11)

	print_page(self):
		""" Descrements the number of pages when printed using queue method"""
		if self.pages > 0:
			self.pages -= 1

	check_complete(self):
		"""Check if all pages have been printed or not by returning True or false"""
		return self.pages == 0

class Printer:
	def __init__(self):
		self.current_job=None

	def get_job(self, print_queue):
		try:
			self.current_job = print_queue.dequeue()

		except IndexError: #Queue is empty
			return "No more jobs to print."

	def print_job(self, job):
		while job.pages > 0:
			job.print_page()

		if job.check_complete():
			print "Printing Complete." 
		else:
			return "An error Occured."