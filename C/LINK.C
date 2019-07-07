// Write a C Program to create a linked-list, insert at the front and display the contents of the linked-list
// Author: Mukul Milind Mishra
// Last Modified: 07-07-2019

#include<stdio.h>
#include<conio.h>
#include<process.h>
#include<stdlib.h>

#define MALLOC(p,n,type)                      \
	p=(type*)malloc(n*sizeof(type));          \
	if(p==NULL)                               \
	{                                         \
		printf("Insuffecient Memory\n");      \
		exit(0);                              \
	}

struct node
{
	int info;
	struct node *link;
};
typedef struct node *NODE;

NODE insert_front(int item,NODE first)
{
	NODE temp;
	MALLOC(temp,1,struct node);
	temp->info=item;
	temp->link=first;
	return temp;
}
void display(NODE first)
{
	NODE temp;
	if(first==NULL)
	{
		printf("List s empty\n");
		return;
	}
	printf("The contents of the list are:\n\n");
	temp=first;
	while(temp!=NULL)
	{
		printf("%d\t",temp->info);
		temp=temp->link;
	}
	printf("\n\n");
}
void main()
{
	NODE first=NULL;
	int choice,item;
	clrscr();
	for(;;)
	{
		printf("Enter your choice\n");
		printf("1.Insert front\t2.Display\t3.Quit\n");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:printf("Enter the item to be inserted\n");
			       scanf("%d",&item);
			       first=insert_front(item,first);
			       break;
			case 2:display(first);
			       break;
			default:exit(0);
		}
	}
}


