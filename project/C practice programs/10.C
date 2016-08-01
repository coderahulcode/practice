#include<stdio.h>
#include<conio.h>
void main()
{
int n,i,j,k;
printf("Enter no of rows in diamond=");
scanf("%d",&n);
/////////////////upper/////////////
for(i=1;i<=n;i++)
{
for(j=1;j<n-i;j++)
printf(" ");
for(k=1;k<=2*i-1;k++)
{
printf("*");
}
printf("\n");
}
//////////lower///////
for(i=n-1;i>=1;i--)
{
for(j=1;j<n-i;j++)
printf(" ");
for(k=1;k<=2*i-1;k++)
{
printf("*");
}
printf("\n");
}
getch();
}