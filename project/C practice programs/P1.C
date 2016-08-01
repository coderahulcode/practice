#include<stdio.h>
#include<conio.h>
void main()
{
int x[10]={1,2,3,4,5,6,7,8,9,0};
int i;
clrscr();
//printf("%d",*x);
for(i=0;i<10;i++)
printf(" *(x+%d)=%d\n",i,*(x+i));
//printf("x[%d]=%d\n",i,x[i]);
getch();
}