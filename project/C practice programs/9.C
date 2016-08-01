#include<stdio.h>
#include<conio.h>
void main()
{
int i,n;
float s,sum=0;
printf("Enter no of value to sum found=");
scanf("%d",&n);
printf("Enter the values\n");
for(i=0;i<n;i++)
{
scanf("%f",&s);
sum=sum+s;
}
printf("Sum of given %d no=%f",n,sum);
getch();
}