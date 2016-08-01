#include<stdio.h>
#include<conio.h>
void main()
{
int *x[100];
int b[100];
int i,n;
clrscr();
printf("Enter no of elements=");
scanf("%d",&n);
printf("ENter elements\n");
for(i=0;i<n;i++)
{
scanf("%d",&b[i]);
x[i]=&b[i];
}
for(i=0;i<n;i++)
{
printf("VALUE OF A[%d]=%d           ADDRESS OF A[%d]=%d\n",i,b[i],i,x[i]);
}
getch();
}