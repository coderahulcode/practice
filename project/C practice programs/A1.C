#include<stdio.h>
#include<conio.h>
void main()
{
int a[10],i;
printf("Enter 10 elements\n");
for(i=0;i<10;i++)
{
scanf("%d",&a[i]);
}
for(i=0;i<10;i++)
{
printf("a[%d]=%d\n",i,a[i]);
}
getch();
}