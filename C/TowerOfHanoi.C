// Write a C Program to count the minimum number of moves required to move discs from Source to Destination in Tower of Hanoi.
// Author: Mukul Milind Mishra
// Last Modified: 07-07-2019

#include<stdio.h>
#include<conio.h>
void tower(int n,char source,char temp,char destination)
{
	if(n==0)return;
	tower(n-1,source,destination,temp);
	printf("Move disc %d from %c to %c\n",n,source,destination);
	tower(n-1,temp,source,destination);
}
void main()
{
	int n;
	clrscr();
	printf("Enter the no of disc.\n");
	scanf("%d",&n);
	tower(n,'A','B','C');
	getch();
}