""" 
	Write a python Program to create a singly linked-list, insert at the front and display the contents of the linked-list
	Author: Mukul Milind Mishra
	Last Modified: 07-07-2019 
"""

class Node(object):

    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next_node = next_node

    def get_data(self):
        return self.data

    def get_next(self):
        return self.next_node

    def set_next(self, new_next):
        self.next_node = new_next

class LinkedList(object):
	
	# The first architectural piece of the linked list is the ‘head node’, which is simply the top node in the list. 
	# When the list is first initialized it has no nodes, so the head is set to None.
	def __init__(self, head=None):
		self.head = head


	# This insert method takes data, initializes a new node with the given data, and adds it to the list. 
	# Technically you can insert a node anywhere in the list, but the simplest way to do it is to place it at the head of the list and point the new node at the old head
	def insert(self, data):
		new_node = Node(data)
		new_node.set_next(self.head)
		self.head=new_node

	def size(self):
		current = self.head
		count = 0
		while current:
			count += 1
			current = current.get_next()
		return count

	def search(self, data): 
		current = self.head
		found = False
		while current and Found is False:
			if current.get_data() == data:
				found = True
			else:
				current = current.get_next()
		if Current is None:
			raise ValueError("Data is not present in the linked-list")

		return Current