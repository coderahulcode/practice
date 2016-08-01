#include<stdio.h>
#include<conio.h>
void main()
{
int x[2][2]={1,2,3,4};
int i;
clrscr();
printf("First element of aaray=%d\n",*x);
for(i=0;i<4;i++)
{
printf("%d element of array=%d\n",i,*(x+i));
}
getch();
}