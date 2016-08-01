#include<stdio.h>
#include<conio.h>
void main()
{
int i,j,n;
printf("Enter no of rows=");
scanf("%d",&n);
for(i=n;i>=0;i--)
{
for(j=i-1;j>=0;j--)
{
printf("*");
}
printf("\n");
}
getch();
}