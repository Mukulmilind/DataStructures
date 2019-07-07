// Write a C Program to create a stack data strucure and perform, push, pop and display operations using dynamic memory allocation [MALLOC and REALLOC]
// Author: Mukul Milind Mishra
// Last Modified: 07-07-2019

#include<stdio.h>
#include<alloc.h>
#include<conio.h>
#include<process.h>

#define MALLOC(p,n,type)	        	     \
	p=(type*)malloc(n*sizeof(type));         \
	if(p==NULL)                              \
	{                                        \
		printf("Insuffecient Memory\n");     \
		exit(0);                             \
	}                                        \

#define REALLOC(p,n,type)                    \
	p=(type*)realloc(p,n*sizeof(type));      \
	if(p==NULL)                              \
	{                                        \
		printf("Insufficient memory\n");     \
		return;                              \
	}
int SIZE=1,top=-1,*s,item;
void push()
{
	if(top==SIZE-1)
	{
		printf("Stack is full:\n");
		printf("Increase size by 1\n");
		SIZE++;
		REALLOC(s,SIZE,int);
	}
	s[++top]=item;
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
	int choice;
	clrscr();
	MALLOC(s,1,int);
	for(;;)
	{
		printf("Enter the choice\n");
		printf("1.Push	2.Pop	3.Display	4.Exit\n");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:printf("Enter item to insert\n");
			       scanf("%d",&item);
			       push(item,&top,&s);
			       break;
			case 2:item=pop(&top,s);
			       if(item==-1)
				printf("Stack is empty\n");
			       else
				printf("Item deleted=%d\n",item);
			       break;
			case 3:display(top,s);
			       break;
			default:exit(0);
		}
	}
}


