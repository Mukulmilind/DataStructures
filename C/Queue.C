// Write a C Program to create a queue [FIFO] data strucure and perform, insertq, deleteq and display operations
// Author: Mukul Milind Mishra
// Last Modified: 07-07-2019

#include<conio.h>
#include<stdio.h>
#include<process.h>
#define QUE_SIZE 5
int f=0,r=-1,item,q[QUE_SIZE];
void insertq()
{
	if(r==QUE_SIZE-1)
	{
		printf("Que overflow!\n");
		exit(0);
	}
	r=r+1;
	q[r]=item;
}
int deleteq()
{
	if(f>r)
	{
		printf("Queue empty!\n");
		exit(0);
	}
	item=q[f];
	f++;
	return item;
}
void display()
{
	int i;
	if(f>r)
	{
		printf("Queue is empty!\n");
		exit(0);
	}
	for(i=f;i<=r;i++)
	{	printf("%d ",q[i]);
		printf("\n");
	}
}
void main()
{
	int ch,element;
	clrscr();
	while(1)
	{
		printf("Choose any one options\n");
		printf("1:To insert  2:To delete\n3:To display  4:To exit\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: printf("Enter the element\n");
				scanf("%d",&item);
				printf("\n");
				insertq();
				break;
			case 2: element=deleteq();
				printf("The deleted element is %d\n",element);
				printf("\n");
				break;
			case 3: display();
				break;
			case 4: exit(0);
		}
	}
}