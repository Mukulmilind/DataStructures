// Write a C Program to create a stack data strucure and perform, push, pop and display operations
// Author: Mukul Milind Mishra
// Last Modified: 07-07-2019

#include<stdio.h>
#include<conio.h>
#include<process.h>
#define SIZE 5
int top;
int s[10];
int item;
void push()
{
	if(top==SIZE-1)
	{
		printf("Stack Overflow\n");
		return;
	}
	top=top+1;
	s[top]=item;
}
int pop()
{
	if(top==-1)return -1;
	return s[top--];
}
void display()
{
	int i;
	if(top==-1)
	{
		printf("Stack is empty\n");
		return;
	}
	printf("Contents of the stack\n");
	for(i=0;i<=top;i++)
		printf("%d\n",s[i]);
}
void main()
{
	int item_deleted;
	int choice;
	top=-1;
	for(;;)
	{
		printf("Enter your choice\n");
		printf("1.Push	2.Pop	3.Display	4.Exit\n");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:printf("Enter the item to insert\n");
			       scanf("%d",&item);
			       push();
			       break;
			case 2:item_deleted=pop();
			       if(item_deleted==-1)
				printf("Stack is empty\n");
			       else
				printf("Item deleted is %d\n",item_deleted);
			       break;
			case 3:display();
			       break;
			case 4:exit(0);
		}
	}
}



