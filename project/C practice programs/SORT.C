#include<stdio.h>
#include<conio.h>
void main()
{
int a[20],i,n,j,t;
clrscr();
printf("Enter no of values=");
scanf("%d",&n);
printf("Enter the values\n");
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
for(i=0;i<n-1;i++)
{
for(j=0;j<n-1;j++)
{
if(a[j]>a[j+1])
{
t=a[j];
a[j]=a[j+1];
a[j+1]=t;
}
}}
printf("Sorted elements of array are\n");
for(i=0;i<n;i++)
{
printf("%d\n",a[i]);
}
printf("Greater element=%d\n",a[n-1]);
printf("Smallest element=%d",a[0]);
getch();
}